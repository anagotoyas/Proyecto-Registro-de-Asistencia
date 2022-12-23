import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router } from '@angular/router';
import { RegistroasistenciaService } from 'src/app/admin/shared/registroasistencia.service';
import { AdminService } from 'src/app/admin/shared/admin.service';
import { RegistroAsistencia } from 'src/app/admin/shared/registroasistencia';
import { MatTableDataSource } from '@angular/material/table';

@Component({
  selector: 'app-estudiante',
  templateUrl: './estudiante.component.html',
  styleUrls: ['./estudiante.component.css']
})
export class EstudianteComponent implements OnInit {
  yeargrado:any
  grado=''
  lista:any
  nombre: any
  bim:any
  idBim:any
  idgrado:any
  displayedColumns2: string[] = ['Fecha','Estado'];
  dataSource: MatTableDataSource<RegistroAsistencia>;
  constructor(
    private registroAsistenciaService: RegistroasistenciaService,
    private router:Router,
    private activeRoute: ActivatedRoute,
    private adminService: AdminService
  ){}

  ngOnInit():void{
    const params = this.activeRoute.snapshot.params;
    this.getInfoGrado();
    this.getBimestres()

    this.getInfoUser(params['idUsuario'])
    this.idgrado=params['idGrado']
    this.getInfoBimestre(params['idBim'])
    this.idBim=params['idBim']
    this.consulta(params['idUsuario'],params['idBim'])
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
      console.log(this.lista)
    })
  }

  getInfoUser(id:number){
    this.adminService.getUsuarioPorId(id).subscribe((data:any)=>{
      this.nombre=data.dato.nombre+' '+data.dato.apellidoPaterno
    })
  }

  getInfoBimestre(idBim:number){
    this.adminService.getInfoBim(idBim).subscribe((data:any)=>{
      this.bim=data.dato.nombreBimestre
    })
  }
  consulta(number: any, bimo:any){
    console.log(number)
    this.registroAsistenciaService.getRegistrosEstudianteBimestre(number,bimo).subscribe((data:any)=>{
      this.dataSource=data.dato
      console.log(data.dato)
    })
    this.router.navigate([`/admin/reporteAsistencia/ver/${localStorage.getItem('idGrado')}/${number}/${bimo}`]);
  }
  


}
