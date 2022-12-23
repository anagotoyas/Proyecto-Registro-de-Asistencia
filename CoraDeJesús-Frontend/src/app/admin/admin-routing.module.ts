import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LayoutComponent } from '../admin/layout/layout.component';
import { ElegirAsistenciaComponent } from './asistencia/elegir-asistencia/elegir-asistencia.component';
import { VerAsistenciaComponent } from './asistencia/ver-asistencia/ver-asistencia.component';
import { HomeAdmComponent } from './home-adm/home-adm.component';
import {ReporteAsistenciasComponent} from "./reporte-asistencias/reporte-asistencias.component";
import {ReportefaltasComponent} from "./reportefaltas/reportefaltas.component";
import {FormControl, Validators} from '@angular/forms';
import { VerEstudiantesComponent } from './reporte-asistencias/ver-estudiantes/ver-estudiantes.component';
import { EstudianteComponent } from './reporte-asistencias/ver-estudiantes/estudiante/estudiante.component';



const routes: Routes = [{
  path:'',
  component: LayoutComponent,
  children: [
    {
      path:'',
      component: HomeAdmComponent,
    },
    {
      path: 'elegir',
      component: ElegirAsistenciaComponent
    },
    {
      path: ':id/asistencia',
      component: VerAsistenciaComponent,
    },
    {
      path: 'reporteAsistencia',
      component: ReporteAsistenciasComponent,
    },
    {
      path: 'reporteFaltas',
      component: ReportefaltasComponent,
    },
    {
      path: 'reporteAsistencia/ver/:idGrado',
      component: VerEstudiantesComponent,
    },
    {
      path: 'reporteAsistencia/ver/:idGrado/:idUsuario/:idBim',
      component: EstudianteComponent,
    },
  ],
},];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }
