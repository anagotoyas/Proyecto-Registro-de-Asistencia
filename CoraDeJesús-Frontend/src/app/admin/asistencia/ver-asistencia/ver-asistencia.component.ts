import { DatePipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { MatTableDataSource } from '@angular/material/table';
import { ActivatedRoute } from '@angular/router';
import { RegistroAsistencia } from '../../shared/registroasistencia';
import { RegistroasistenciaService } from '../../shared/registroasistencia.service';

@Component({
  selector: 'app-ver-asistencia',
  templateUrl: './ver-asistencia.component.html',
  styleUrls: ['./ver-asistencia.component.css']
})

export class VerAsistenciaComponent implements OnInit{

  megadate: Date = new Date('12/13/2022');
  displayedColumns: string[] = ['position', 'name', 'status', 'date'];
  dataSource = new MatTableDataSource<RegistroAsistencia>();

  params = this.activatedRoute.snapshot.params;
  grado= this.params['id'];

  form = new FormGroup({
    filtrazo: new FormControl(null, {
      validators: [
        Validators.required
      ]
    })
  });

  constructor(
    private registroAsistenciaService: RegistroasistenciaService,
    public datePipe: DatePipe,
    private activatedRoute: ActivatedRoute
  ){}

  ngOnInit(): void{
    this.getRegistros();
  }

  getRegistros(){
    const params = this.activatedRoute.snapshot.params;
    console.log(params['id']);
    const grado= params['id'];
    
    this.registroAsistenciaService.getRegistrosByGrado(params['id']).subscribe((data:any) => {
      this.dataSource = new MatTableDataSource(data["dato"]);
      console.log(this.dataSource.data);
      
      //console.log(Number(sessionStorage.getItem('idUsuario')));
      //this.estado=data['body'].estadoPedido.nombreEstado;
    })
  }
  
  applyDateFilter(){
    console.log(this.form.value.filtrazo);
    console.log(this.dataSource.data);
    console.log(this.dataSource.data[1]);

    const dato = this.formatoInput()
    console.log(dato);
    console.log(dato.getDate());
    
    return this.dataSource.data = this.dataSource.data.filter(e=> new Date(e.fecha).getFullYear()  === dato.getFullYear() && new Date(e.fecha).getMonth()  === dato.getMonth() && new Date(e.fecha).getDate()  === dato.getDate());
  }

  formatoInput(){
    var datazo : Date= this.form.value.filtrazo!;
    const ano = datazo.getFullYear(); 
    const mes = datazo.getMonth(); 
    const dia = datazo.getDate() - 1;
    
    const final = new Date(ano,mes,dia);
    console.log(final);
    
    return final;
  }

  clearFilters(){
    this.getRegistros();
    this.dataSource.filter = '';
 }
 
}