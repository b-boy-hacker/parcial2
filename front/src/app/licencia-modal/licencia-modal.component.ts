import { Component, Input, Output, EventEmitter } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

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
  docentes: Docente[]; // Cambia docentes a ser un arreglo de Docente
}


@Component({
  selector: 'app-licencia-modal',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './licencia-modal.component.html',
  styleUrls: ['./licencia-modal.component.css']
})
export class LicenciaModalComponent {
  @Input() licencia: Licencia = {
    id: 0,
    fechaInicio: new Date(),
    fechaFin: new Date(),
    motivo: '',
    estado: '',
    docentes: [] // Inicializa como un arreglo vacío
  };  @Input() isEditMode = false;
  @Output() closeModal = new EventEmitter<void>();
  @Output() saveLicencia = new EventEmitter<Licencia>();

  onClose() {
    this.closeModal.emit();
  }

  onSave() {
    this.saveLicencia.emit(this.licencia);
  }
}


