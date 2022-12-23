import { Component,OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Estudiante } from '../shared/Estudiante.model';
import { EstudianteService } from '../shared/estudiante.service';

@Component({
  selector: 'app-layout',
  templateUrl: './layout.component.html',
  styleUrls: ['./layout.component.css']
})
export class LayoutComponent implements OnInit {

  estudiante:Estudiante;

  nombres:string
  idUsuario=Number(sessionStorage.getItem('idUsuario'))
  
  constructor(
    private router:Router,
    private estudianteService: EstudianteService,
    ){
    let strg=localStorage.getItem('userSesion')
    if(strg=="" || strg==null){
      router.navigateByUrl("login")
    }
    else{
      this.estudiante=JSON.parse(strg)
    }
  }

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
