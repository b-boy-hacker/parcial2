import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class LicenciaService {
  private apiUrl = 'http://192.168.56.1/licencias'; // Reemplaza con tu URL de la API

  constructor(private http: HttpClient) { }

  // Método para obtener todas las licencias
  getAllLicencias(): Observable<any[]> {
    return this.http.get<any[]>(this.apiUrl);
  }

  // Método para obtener una licencia por su ID
  getLicenciaById(id: number): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/${id}`);
  }

  // Método para crear una nueva licencia
  createLicencia(licencia: any): Observable<any> {
    return this.http.post<any>(this.apiUrl, licencia);
  }

  // Método para actualizar una licencia existente
  updateLicencia(id: number, licencia: any): Observable<any> {
    return this.http.put<any>(`${this.apiUrl}/${id}`, licencia);
  }

  // Método para eliminar una licencia por su ID
  deleteLicencia(id: number): Observable<any> {
    return this.http.delete<any>(`${this.apiUrl}/${id}`);
  }
}

// import { Injectable } from '@angular/core';

// @Injectable({
//   providedIn: 'root'
// })
// export class LicenciaService {

//   constructor() { }
// }
