import { Component, OnInit } from '@angular/core';
import { RegistroasistenciaService } from '../shared/registroasistencia.service';
import {Router} from '@angular/router';
import { local } from 'd3';

@Component({
  selector: 'app-reporte-asistencias',
  templateUrl: './reporte-asistencias.component.html',
  styleUrls: ['./reporte-asistencias.component.css']
})
export class ReporteAsistenciasComponent implements OnInit{
  inputValue:any
  year:any
  years = [2018,2019,2020]
  numero:any
  grado:any

  constructor(
    private registroAsistenciaService: RegistroasistenciaService,
    private router:Router

  ){}

  ngOnInit(): void{
    
   

  }

  listarGrados(){
    this.registroAsistenciaService.getGrados().subscribe((data:any) =>{
      var lista = data.dato;
      lista =lista.filter((x: { year: { year: Number; }; }) => x.year.year==this.year)
      lista=lista.filter((x:{nombreGrado:String})=> x.nombreGrado.slice(5,6)==this.numero)
      this.grado=lista[0].idGrado
      localStorage.setItem('idGrado', this.grado)
      this.router.navigate([`/admin/reporteAsistencia/ver/${this.grado}`]);
     
    })
  }

  



  open(numero:any){
    this.numero=numero
    console.log(this.year, numero);
    this.listarGrados();
  }

  cambio(year:any){
    this.year=year
    sessionStorage.setItem('year', this.year)
    
  }

}
