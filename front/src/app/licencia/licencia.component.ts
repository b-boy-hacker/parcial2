import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

interface Docente {
  id: number;
  nombre: string;
}

interface Licencia {
  id: number;
  fechaInicio: Date;
  fechaFin: Date;
  motivo: string;
  estado: string;
  docente: {
    id: number | null;
    nombre: string;
  };
}

@Component({
  selector: 'app-licencia',
  templateUrl: './licencia.component.html',
  styleUrls: ['./licencia.component.css']
})
export class LicenciaComponent implements OnInit {
  licencias: Licencia[] = [];
  selectedLicencia: Licencia = { id: 0, fechaInicio: new Date(), fechaFin: new Date(), motivo: '', estado: '', docente: { id: null, nombre: '' } };
  showModal = false;
  showConfirmModal = false;
  isEditMode = false;
  licenciaIdToDelete: number | null = null;
  toastMessage: string | null = null;
  toastClass: string = '';

  // Variable para almacenar los docentes
  docente: Docente[] = [];

  constructor(private http: HttpClient) {}

  ngOnInit(): void {
    this.loadLicencias();
    this.loadDocentes();
  }

  loadLicencias() {
    this.http.get<Licencia[]>('http://192.168.56.1/licencias').subscribe(
      data => {
        this.licencias = data;
      },
      error => {
        console.error('Error loading licencias', error);
      }
    );
  }

  loadDocentes() {
    this.http.get<Docente[]>('http://192.168.56.1/docentes/').subscribe(
      data => {
        this.docente = data;
      },
      error => {
        console.error('Error loading docentes', error);
      }
    );
  }

  saveLicencia(licencia: Licencia) {
    if (this.isEditMode) {
      this.http.put<Licencia>(`http://192.168.56.1/licencias/${licencia.id}`, licencia).subscribe(
        response => {
          this.showToast('Licencia actualizada con éxito', 'success');
          this.loadLicencias();
        },
        error => {
          this.showToast('Error al actualizar la licencia', 'error');
          console.error('Error updating licencia', error);
        }
      );
    } else {
      this.http.post<Licencia>('http://192.168.56.1/licencias/', licencia).subscribe(
        response => {
          this.showToast('Licencia creada con éxito', 'success');
          this.loadLicencias();
        },
        error => {
          this.showToast('Error al crear la licencia', 'error');
          console.error('Error creating licencia', error);
        }
      );
    }
    this.handleCloseModal();
  }

  deleteLicencia() {
    if (this.licenciaIdToDelete !== null) {
      this.http.delete(`http://192.168.56.1/licencias/${this.licenciaIdToDelete}`).subscribe(
        () => {
          this.showToast('Licencia eliminada con éxito', 'success');
          this.loadLicencias();
          this.licenciaIdToDelete = null;
          this.showConfirmModal = false;
        },
        error => {
          this.showToast('Error al eliminar la licencia', 'error');
          console.error('Error deleting licencia', error);
        }
      );
    }
  }

  handleCloseModal() {
    this.showModal = false;
  }

  handleCloseConfirmModal() {
    this.showConfirmModal = false;
  }

  showToast(message: string, type: string) {
    this.toastMessage = message;
    this.toastClass = type === 'success' ? 'bg-green-500 text-white' : 'bg-red-500 text-white';
    setTimeout(() => {
      this.toastMessage = null;
    }, 2000);
  }

  confirmDelete(licenciaId: number) {
    this.licenciaIdToDelete = licenciaId;
    this.showConfirmModal = true;
  }

  editLicencia(licenciaId: number) {
    this.selectedLicencia = this.licencias.find(licencia => licencia.id === licenciaId) || this.selectedLicencia;
    this.isEditMode = true;
    this.showModal = true;
  }

  addLicencia() {
    this.selectedLicencia = { id: 0, fechaInicio: new Date(), fechaFin: new Date(), motivo: '', estado: '', docente: { id: null, nombre: '' } };
    this.isEditMode = false;
    this.showModal = true;
  }

  onClose() {
    this.handleCloseModal();
  }
}
