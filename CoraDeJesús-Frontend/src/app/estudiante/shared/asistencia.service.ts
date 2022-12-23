import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Asistencia } from './asistencia.model';

@Injectable({
  providedIn: 'root'
})
export class AsistenciaService {
  private apiBase: string=environment.apiBase;

  constructor(private http:HttpClient) { }

  getRegistrosByEstudAndBim(idEstud: number, idBim: number){
    console.log(idEstud);
    console.log(idBim);
    
    return this.http.get<Asistencia[]>(this.apiBase+`/registro_asistencias/estudiante/${idEstud}/bimestre/${idBim}`)
  }
}
