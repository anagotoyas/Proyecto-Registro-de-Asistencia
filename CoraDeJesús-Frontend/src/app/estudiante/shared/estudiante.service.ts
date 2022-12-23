import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { RegistroAsistencia } from 'src/app/admin/shared/registroasistencia';
import { Bimestre } from 'src/app/docente/shared/bimestre';
import { Grado } from 'src/app/docente/shared/grado';
import { environment } from 'src/environments/environment';
import { Estudiante } from './Estudiante.model';

@Injectable({
  providedIn: 'root'
})
export class EstudianteService {
  private apiBase: string=environment.apiBase;

  constructor(private http:HttpClient) { }

  getDatosOfEstud(idEstud:number){
    console.log(idEstud);

    return this.http.get<Estudiante>(this.apiBase+`/estudiantes/${idEstud}`)
  }

  getGrados(){
    return this.http.get<Grado>(this.apiBase+`/grados`)
    }
  
  getGradosEstudiante(idUsuario:number){
    return this.http.get<Grado[]>(this.apiBase+`grados/registroGrados/${idUsuario}`)
    }

  getBimestres(){
    return this.http.get<Bimestre[]>(this.apiBase+`bimestres`)
  }

  getRegistrosEstudianteByGradoBim(idUsuario:any,idGrado:any, idBim:any){
    return this.http.get<RegistroAsistencia[]>(this.apiBase+`registro_asistencias/Grado/${idGrado}/Estudiante/${idUsuario}/Bimestre/${idBim}`)
  }

  getBimestre(idBim:number){
    return this.http.get<Bimestre>(this.apiBase+`bimestres/${idBim}`)
  }

}

