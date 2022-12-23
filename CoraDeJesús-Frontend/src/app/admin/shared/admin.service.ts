import { Injectable } from '@angular/core';
import {environment} from "../../../environments/environment";
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { Admin } from './admin';
import { Usuario } from 'src/app/docente/shared/usuario';
import { Bimestre } from 'src/app/docente/shared/bimestre';

@Injectable({
  providedIn: 'root'
})
export class AdminService {
  private apiBase: string = environment.apiBase;

  constructor(private http: HttpClient) { }


  getFaltas(bimestre: string, anio: number){
    return this.http.get(`${this.apiBase}/registro_asistencias/faltas/${bimestre}/${anio}`).pipe( map( data => data ));
  }

  getDatosOfAdmin(idAdmin:number){
    return this.http.get<Admin>(this.apiBase+`/admins/${idAdmin}`)
  }
  getUsuarioPorId(idUsuario:any){
    return this.http.get<Usuario>(`${this.apiBase}/usuarios/${idUsuario}`);
  }

  getInfoBim(idBim:any){
    return this.http.get<Bimestre>(`${this.apiBase}/bimestres/${idBim}`)
  }
}
