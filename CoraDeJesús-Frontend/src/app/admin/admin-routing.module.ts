import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LayoutComponent } from '../admin/layout/layout.component';
import { ElegirAsistenciaComponent } from './asistencia/elegir-asistencia/elegir-asistencia.component';
import { VerAsistenciaComponent } from './asistencia/ver-asistencia/ver-asistencia.component';
import { HomeAdmComponent } from './home-adm/home-adm.component';
import {ReporteAsistenciasComponent} from "./reporte-asistencias/reporte-asistencias.component";
import {ReportefaltasComponent} from "./reportefaltas/reportefaltas.component";
import {FormControl, Validators} from '@angular/forms';



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
      path: 'elegir/asistencia',
      component: VerAsistenciaComponent,
    },
    {
      path: 'reporteAsistencia',
      component: ReporteAsistenciasComponent,
    },
    {
      path: 'reporteFaltas',
      component: ReportefaltasComponent,
    }
  ],
},];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }
