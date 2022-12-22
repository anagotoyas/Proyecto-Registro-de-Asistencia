import { Component, OnInit } from '@angular/core';
import { Estudiante } from '../shared/Estudiante.model';
import { EstudianteService } from '../shared/estudiante.service';

@Component({
  selector: 'app-elegir-asistencia',
  templateUrl: './elegir-asistencia.component.html',
  styleUrls: ['./elegir-asistencia.component.css']
})
export class ElegirAsistenciaComponent implements OnInit{

  estudiante:Estudiante;
  nombres:string;
  idUsuario=Number(sessionStorage.getItem('idUsuario'))

  mover(idBim:number){
    window.location.replace(`estud/${idBim}/registro`);
  }

  constructor(
    private estudianteService: EstudianteService
  ){}

  ngOnInit(): void {
    this.obtenerDatos();

  }
  obtenerDatos(){
    this.estudianteService.getDatosOfEstud(this.idUsuario).subscribe((data:any) => {
      console.log(this.idUsuario);
      
      this.estudiante = data["dato"];
      this.nombres = this.estudiante.nombre + ' ' + this.estudiante.apellidoPaterno + ' ' + this.estudiante.apellidoMaterno    
      
      console.log(this.estudiante);
      
    })
  }


}
