import { Component } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { EstudianteService } from 'src/app/estudiante/shared/estudiante.service';
import { DocenteService } from '../../shared/docente.service';
import { Grado } from '../../shared/grado';

import { RegistroAsistencia } from '../../shared/registro_asistencia';
import Swal from 'sweetalert2';
import { RegistroAsistenciaService } from '../../shared/registro_asistencia.service';

@Component({
  selector: 'app-incidencias',
  templateUrl: './incidencias.component.html',
  styleUrls: ['./incidencias.component.css']
})
export class IncidenciasComponent {

  grado:any
  nombre:any
  dataza: RegistroAsistencia[]
  dataSource: MatTableDataSource<RegistroAsistencia>;
  displayedColumns: string[] = ['id', 'nombre', 'incidencia', 'boton'];

  constructor(public docenteService: DocenteService,
    public estudianteService: EstudianteService,
    public registroService: RegistroAsistenciaService

    ) { }

  ngOnInit(): void {

    const id = localStorage.getItem('idTutor');

    this.docenteService.getGradosPorTutor(id).subscribe((data:Grado[]) => {
      
      for (let element of data){
        if (element.year.year == 2020){

          this.grado = element
          this.nombre = element.nombreGrado
        }
      }

      this.registroService.listarIncidenciasporGrado(this.grado.idGrado).subscribe((data:any) => {

        this.dataSource = new MatTableDataSource(data['dato']);
        
        console.log(this.dataSource)
      })
        
      })

    
  }

  enviarCorreo(idRegistro: number, idEstudiante: number){
    this.docenteService.enviarCorreo(idRegistro, idEstudiante).subscribe((data) => {
      
      console.log("si se pudooo")
      
    })
  }

  showModal() {
    Swal.fire (
      '¡Enviado!',
      'Se ha enviado el mensaje',
      'success'
    );
  }
}
