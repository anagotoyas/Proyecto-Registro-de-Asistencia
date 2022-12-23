import { Component, OnInit } from '@angular/core';
import { Grado } from 'src/app/docente/shared/grado';
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
  grados: Grado[]
  grado:any
  bimes:any
  lista:any
  year:any
  bim1:any
  bim2:any
  bim3:any
  bim4:any
  nombresG:[]

  mover(idBim:number){
    window.location.replace(`estud/${idBim}/registro`);
    console.log('bimestreee')
    console.log(idBim)
  }

  constructor(
    private estudianteService: EstudianteService
  ){}

  ngOnInit(): void {
    this.obtenerDatos();
    this.getGrados();

  }
  obtenerDatos(){
    this.estudianteService.getDatosOfEstud(this.idUsuario).subscribe((data:any) => {
      console.log(this.idUsuario);
      
      this.estudiante = data["dato"];
      this.nombres = this.estudiante.nombre + ' ' + this.estudiante.apellidoPaterno + ' ' + this.estudiante.apellidoMaterno    
      
      console.log(this.estudiante);
      
    })
  }

  cambio(grado:any){
    this.grado=grado.idGrado
    sessionStorage.setItem('grado',this.grado)
   this.year=grado.year.year
    console.log(grado)
    console.log(this.grado)
    console.log(this.year)
    this.getBimestres()
    
    
  }

  getGrados(){
    this.estudianteService.getGradosEstudiante(Number(sessionStorage.getItem('idUsuario'))).subscribe((data:any) => {
      this.grados=data.dato
      
      
      console.log(data.dato)
    })
  }

  getBimestres(){
    this.estudianteService.getBimestres().subscribe((data:any) =>{
      this.bimes=data.dato
      this.lista=this.bimes.filter((x:{year:{year:Number;};})=>x.year.year==this.year)
      console.log(this.lista)
      for(var i=0; i<this.lista.length;i++){
        if(this.lista[i].nombreBimestre==String(this.year)+'-01'){
          this.bim1=this.lista[i].idBimestre
          console.log(this.lista)
        }
        if(this.lista[i].nombreBimestre==String(this.year)+'-02'){
          this.bim2=this.lista[i].idBimestre
        }
        if(this.lista[i].nombreBimestre==String(this.year)+'-03'){
          this.bim3=this.lista[i].idBimestre
        }
        if(this.lista[i].nombreBimestre==String(this.year)+'-04'){
          this.bim4=this.lista[i].idBimestre
        }
      }
     
    })
  }

  

  


}
