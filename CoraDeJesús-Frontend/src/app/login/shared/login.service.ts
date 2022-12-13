import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment.prod';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  private apiBase:string =environment.apiBase;
  constructor(private http: HttpClient) { }

  login(usuario: any) {
    return this.http.post<any>(this.apiBase+'/usuarios/login',usuario);
  }
} 
