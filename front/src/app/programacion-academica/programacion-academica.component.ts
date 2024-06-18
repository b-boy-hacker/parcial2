import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

interface ProgramacionAcademicaDTO {
  id?: number;
  materiaId: number;
  aulaId: number;
  docenteIds: number[];
  sesionClaseIds: number[];
  grupo: string;
}

@Component({
  selector: 'app-programacion-academica',
  templateUrl: './programacion-academica.component.html',
  standalone: true,
  imports: [FormsModule],
  styleUrls: ['./programacion-academica.component.css']
})
export class ProgramacionAcademicaComponent implements OnInit {

  apiUrl = 'http://192.168.56.1/programacionesacademicas/';

  programacionesAcademicas: ProgramacionAcademicaDTO[] = [];
  nuevaProgramacionAcademica: ProgramacionAcademicaDTO = {
    materiaId: 0,
    aulaId: 0,
    docenteIds: [],
    sesionClaseIds: [],
    grupo: ''
  };

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    this.loadProgramacionesAcademicas();
  }

  loadProgramacionesAcademicas() {
    this.http.get<ProgramacionAcademicaDTO[]>(this.apiUrl).subscribe(
      data => {
        this.programacionesAcademicas = data;
      },
      error => {
        console.error('Error loading programaciones académicas', error);
      }
    );
  }

  crearProgramacionAcademica() {
    this.http.post<ProgramacionAcademicaDTO>(this.apiUrl, this.nuevaProgramacionAcademica).subscribe(
      response => {
        console.log('Programación académica creada con éxito', response);
        this.loadProgramacionesAcademicas(); // Recargar la lista después de crear
      },
      error => {
        console.error('Error al crear programación académica', error);
      }
    );
  }

  actualizarProgramacionAcademica(id: number) {
    // Implementa la lógica según tus necesidades
  }

  eliminarProgramacionAcademica(id: number) {
    this.http.delete(`${this.apiUrl}/${id}`).subscribe(
      () => {
        console.log('Programación académica eliminada con éxito');
        this.loadProgramacionesAcademicas(); // Recargar la lista después de eliminar
      },
      error => {
        console.error('Error al eliminar programación académica', error);
      }
    );
  }
}

// import { Component } from '@angular/core';

// @Component({
//   selector: 'app-programacion-academica',
//   standalone: true,
//   imports: [],
//   templateUrl: './programacion-academica.component.html',
//   styleUrl: './programacion-academica.component.css'
// })
// export class ProgramacionAcademicaComponent {
  
// }
