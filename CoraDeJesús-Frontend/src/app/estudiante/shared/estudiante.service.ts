import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
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
}
