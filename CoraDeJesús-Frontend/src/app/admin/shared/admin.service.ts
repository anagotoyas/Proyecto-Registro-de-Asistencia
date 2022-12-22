import { Injectable } from '@angular/core';
import {environment} from "../../../environments/environment";
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { Admin } from './admin';

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
}
