import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { RegistroAsistencia } from './registro_asistencia';

@Injectable({
  providedIn: 'root'
})
export class RegistroAsistenciaService {

  private apiBase: string = environment.apiBase;

  constructor(private http: HttpClient) { }

  listarPorGrado(id: number){
    return this.http.get<RegistroAsistencia[]>(`${this.apiBase}/registro_asistencias/grado/${id}`);
  }

  listarIncidenciasporGrado(id: number){
    return this.http.get<RegistroAsistencia[]>(`${this.apiBase}/registro_asistencias/incidencia/${id}`);
  }
}
