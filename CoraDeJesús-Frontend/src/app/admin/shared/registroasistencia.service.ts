import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { RegistroAsistencia } from './registroasistencia';

@Injectable({
  providedIn: 'root'
})
export class RegistroasistenciaService {
  private apiBase: string=environment.apiBase;

  constructor(private http:HttpClient) { }

  getRegistrosByGrado(idGrado: number){
    console.log(idGrado);
    
    return this.http.get<RegistroAsistencia[]>(this.apiBase+`/registro_asistencias/grado/${idGrado}`)
  }

}
