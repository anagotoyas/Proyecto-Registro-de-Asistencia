import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { ActivatedRoute } from '@angular/router';
import { Asistencia } from '../shared/asistencia.model';
import { AsistenciaService } from '../shared/asistencia.service';
import { Estudiante } from '../shared/Estudiante.model';
import { EstudianteService } from '../shared/estudiante.service';

@Component({
  selector: 'app-ver-asistencia',
  templateUrl: './ver-asistencia.component.html',
  styleUrls: ['./ver-asistencia.component.css']
})

export class VerAsistenciaComponent implements OnInit{

  dataSource = new MatTableDataSource<Asistencia>();
  displayedColumns: string[] = ['estado', 'fecha'];
  estudiante: Estudiante;
  nombres: string;

  idUsuario=Number(sessionStorage.getItem('idUsuario'))
  params = this.activatedRoute.snapshot.params;
  bimestre = this.params['id'];

  constructor(
    private asistenciaService: AsistenciaService,
    private activatedRoute: ActivatedRoute,
    private estudianteService: EstudianteService
  ){}

  ngOnInit(): void {
      this.getRegistros();
      this.obtenerDatos();
  }



  getRegistros(){
    this.asistenciaService.getRegistrosByEstudAndBim(this.idUsuario,this.bimestre).subscribe((data:any) => {
      this.dataSource = new MatTableDataSource(data["dato"]);
      console.log(this.dataSource.data);
    })
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
