import { Component } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { Estudiante } from 'src/app/estudiante/shared/Estudiante.model';
import { EstudianteService } from 'src/app/estudiante/shared/estudiante.service';
import { DocenteService } from '../../shared/docente.service';
import { Grado } from '../../shared/grado';


@Component({
  selector: 'app-ver-estudiantes',
  templateUrl: './ver-estudiantes.component.html',
  styleUrls: ['./ver-estudiantes.component.css']
})
export class VerEstudiantesComponent {

    displayedColumns: string[] = ['id', 'name'];
    dataSource: MatTableDataSource<Estudiante>;
    grados:any
    grado:any
    nombre:any
    constructor(public docenteService: DocenteService,
      public estudianteService: EstudianteService) { }
    
    ngOnInit(): void {
      const id = localStorage.getItem('idTutor');

      this.docenteService.getGradosPorTutor(id).subscribe((data:Grado[]) => {
        
        for (let element of data){
          if (element.year.year == 2020){

            this.grado = element
            this.nombre = element.nombreGrado
          }
        }

        this.docenteService.listarEstudPorGrado(this.grado.idGrado).subscribe((data:any) => {
          this.dataSource = new MatTableDataSource(data['dato']);
          
        })
          
        })

      
    }

 

    }
