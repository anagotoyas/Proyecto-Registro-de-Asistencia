import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Bimestre } from 'src/app/docente/shared/bimestre';
import { Estudiante } from 'src/app/estudiante/shared/Estudiante.model';
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

  getGrados(){
    return this.http.get<RegistroAsistencia[]>(this.apiBase+`/grados`)
  }
  getEstudiantesGrado(idGrado:any){
    return this.http.get<Estudiante[]>(`${this.apiBase}/estudiantes/grado/${idGrado}`);
  }

  getGradoId(idGrado:any){
    return this.http.get<RegistroAsistencia>(this.apiBase+`/grados/${idGrado}`)
  }

  getRegistrosEstudianteBimestre(idUsuario:any, idBimestre:any){
    return this.http.get<RegistroAsistencia[]>(this.apiBase+`/registro_asistencias/estudiante/${idUsuario}/bimestre/${idBimestre}`)
  }

  getBimestres(){
    return this.http.get<Bimestre[]>(this.apiBase+`/bimestres`)
  }


}
