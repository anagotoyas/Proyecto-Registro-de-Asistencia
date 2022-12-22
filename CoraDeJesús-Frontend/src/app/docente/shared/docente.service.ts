import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';
import { Tutor } from './tutor';
import { Estudiante } from 'src/app/estudiante/shared/Estudiante.model';
import { Grado } from './grado';
import { RegistroAsistencia } from './registro_asistencia';

@Injectable({
  providedIn: 'root'
})
export class DocenteService {
  private apiBase: string = environment.apiBase;

  private body:string
  constructor(private http: HttpClient) { }

  obtenerTutorPorId(id: any) {
    return this.http.get<Tutor>(`${this.apiBase}/tutores/${id}`);
  }
  
  listarEstudPorGrado(id: any){
    return this.http.get<Estudiante[]>(`${this.apiBase}/estudiantes/grado/${id}`);
  }

  getGradosPorTutor(id: any){
    return this.http.get<Grado[]>(`${this.apiBase}/tutores/${id}/grado`);
  }

  enviarCorreo(idRegistro: any, idEstudiante:any){
    return this.http.post<RegistroAsistencia>(`${this.apiBase}/estudiantes/notificar/${idRegistro}/${idEstudiante}`, this.body);
  }

  
}
