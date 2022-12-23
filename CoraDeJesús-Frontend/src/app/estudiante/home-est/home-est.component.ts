import { Component } from '@angular/core';
import { Estudiante } from '../shared/Estudiante.model';
import { EstudianteService } from '../shared/estudiante.service';

@Component({
  selector: 'app-home-est',
  templateUrl: './home-est.component.html',
  styleUrls: ['./home-est.component.css']
})
export class HomeEstComponent {

  estudiante:Estudiante;

  nombres:string
  idUsuario=Number(sessionStorage.getItem('idUsuario'))


  constructor(
    private estudianteService: EstudianteService,
  ){}

  ngOnInit():void{
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
