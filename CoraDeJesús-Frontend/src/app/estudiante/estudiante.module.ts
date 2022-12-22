import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { EstudianteRoutingModule } from './estudiante-routing.module';
import { HomeEstComponent } from './home-est/home-est.component';
import { LayoutComponent } from './layout/layout.component';
import { VerAsistenciaComponent } from './ver-asistencia/ver-asistencia.component';
import { VerDatosComponent } from './ver-datos/ver-datos.component';
import { MatTableModule } from '@angular/material/table';
import { ElegirAsistenciaComponent } from './elegir-asistencia/elegir-asistencia.component';


@NgModule({
  declarations: [
    HomeEstComponent,
    LayoutComponent,
    VerAsistenciaComponent,
    VerDatosComponent,
    ElegirAsistenciaComponent
  ],
  imports: [
    CommonModule,
    EstudianteRoutingModule,
    MatTableModule
  ]
})
export class EstudianteModule { }
