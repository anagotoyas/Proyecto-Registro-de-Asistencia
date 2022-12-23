import { Component } from '@angular/core';
import { RegistroasistenciaService } from '../../shared/registroasistencia.service';

@Component({
  selector: 'app-elegir-asistencia',
  templateUrl: './elegir-asistencia.component.html',
  styleUrls: ['./elegir-asistencia.component.css']
})
export class ElegirAsistenciaComponent {

  year:any
  years = [2018,2019,2020]
  grado:any
  numero:any

  constructor(
    private registroAsistenciaService: RegistroasistenciaService,

  ){}


  mover(numero:any){
    this.numero=numero
    console.log(this.year, numero);
    this.listarGrados();
  }

  cambio(year:any){
    this.year=year
    sessionStorage.setItem('year', this.year)
  }

  listarGrados(){
    this.registroAsistenciaService.getGrados().subscribe((data:any) =>{
      var lista = data.dato;
      lista =lista.filter((x: { year: { year: Number; }; }) => x.year.year==this.year)
      lista=lista.filter((x:{nombreGrado:String})=> x.nombreGrado.slice(5,6)==this.numero)
      this.grado=lista[0].idGrado
      localStorage.setItem('idGrado', this.grado)
      window.location.replace(`admin/${this.grado}/asistencia`);
     
    })
  }

}