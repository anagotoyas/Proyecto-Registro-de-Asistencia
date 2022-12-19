import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Login } from './Usuario.model';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  private apiBase:string =environment.apiBase;
  constructor(private http: HttpClient) { }

  login(usuario: Login) {
    return this.http.post<any>(this.apiBase+'/usuarios/login',usuario);
  }
} 
