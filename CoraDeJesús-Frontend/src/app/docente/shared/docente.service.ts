import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class DocenteService {
  private apiBase: string = environment.apiBase;

  constructor(private http: HttpClient) { }

  
}
