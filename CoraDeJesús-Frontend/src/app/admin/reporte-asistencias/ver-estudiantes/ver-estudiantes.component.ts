import { Component,OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { Router } from '@angular/router';
import { Estudiante } from 'src/app/estudiante/shared/Estudiante.model';
import { RegistroasistenciaService } from '../../shared/registroasistencia.service';
import {MatIconModule} from '@angular/material/icon';

@Component({
  selector: 'app-ver-estudiantes',
  templateUrl: './ver-estudiantes.component.html',
  styleUrls: ['./ver-estudiantes.component.css']
})
export class VerEstudiantesComponent implements OnInit {
  grado=''
  lista:any
  yeargrado:any
  bim:any
  bim2:any
  bim3:any
  bim4:any
  name:any
  displayedColumns2: string[] = ['idUsuario',  'Estudiante','1b','2b','3b','4b'];
  dataSource: MatTableDataSource<Estudiante>;
  constructor(
    private registroAsistenciaService: RegistroasistenciaService,
    private router:Router
  ){}

  ngOnInit():void{
    this.getInfoGrado();
    this.listarEstudiantes();
    this.getBimestres();
    
  }

  listarEstudiantes(){
   
    this.registroAsistenciaService.getEstudiantesGrado( localStorage.getItem('idGrado')).subscribe((data:any) =>{
      this.dataSource=data.dato
     
      console.log(data.dato)
    })
    
  }

  getInfoGrado(){
    this.registroAsistenciaService.getGradoId(localStorage.getItem('idGrado')).subscribe((data:any) =>{
      console.log(data.dato.nombreGrado.slice(5,7))
      this.grado=data.dato.nombreGrado.slice(5,7)+' '+ 'Grado'
      this.yeargrado=data.dato.year.year
    });
  }
  getBimestres(){
    this.registroAsistenciaService.getBimestres().subscribe((data:any) =>{
     this.lista=data.dato
      this.lista =this.lista.filter((x: { year: { year: Number; }; }) => x.year.year==this.yeargrado)
      for(var i=0; i<this.lista.length;i++){
        if(this.lista[i].nombreBimestre==String(this.yeargrado)+'-01'){
          this.bim=this.lista[i].idBimestre
          console.log(this.lista)
        }
        if(this.lista[i].nombreBimestre==String(this.yeargrado)+'-02'){
          this.bim2=this.lista[i].idBimestre
        }
        if(this.lista[i].nombreBimestre==String(this.yeargrado)+'-03'){
          this.bim3=this.lista[i].idBimestre
        }
        if(this.lista[i].nombreBimestre==String(this.yeargrado)+'-04'){
          this.bim4=this.lista[i].idBimestre
        }
      }
    
      console.log(this.lista)
      
    })
    
   
  }

  consulta(number: any, bimo:any){
    console.log(number)
    
    this.router.navigate([`/admin/reporteAsistencia/ver/${localStorage.getItem('idGrado')}/${number}/${bimo}`]);
  }



}
