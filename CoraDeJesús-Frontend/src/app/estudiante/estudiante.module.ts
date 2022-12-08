import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { EstudianteRoutingModule } from './estudiante-routing.module';
import { HomeEstComponent } from './home-est/home-est.component';
import { LayoutComponent } from './layout/layout.component';
import { VerAsistenciaComponent } from './ver-asistencia/ver-asistencia.component';
import { VerDatosComponent } from './ver-datos/ver-datos.component';
import { MatTableModule } from '@angular/material/table';


@NgModule({
  declarations: [
    HomeEstComponent,
    LayoutComponent,
    VerAsistenciaComponent,
    VerDatosComponent
  ],
  imports: [
    CommonModule,
    EstudianteRoutingModule,
    MatTableModule
  ]
})
export class EstudianteModule { }
