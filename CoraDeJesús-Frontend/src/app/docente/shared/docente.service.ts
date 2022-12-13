import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class DocenteService {
  private apiBase: string = environment.apiBase;

  constructor(private http: HttpClient) { }

  create(resena: Resena) {
    return this.http.post(`${this.apiBase}/resenas`,resena );
  }

  getResenaPorIdHistoria(id: number){
    return this.http.get<Resena[]>(`${this.apiBase}/resenas/buscarPorIdHistoria?historia=${id}`)
  }

  deleteResena(idResena: number) {
    return this.http.delete<Resena>(`${this.apiBase}/resenas/${idResena}`)
  }

  editResena(resena: Resena) {
    return this.http.put(`${this.apiBase}/resenas`,resena );
  }
  
  getResenaPorId(id: number){
    return this.http.get<Resena>(`${this.apiBase}/resenas/${id}`)
  }
}
