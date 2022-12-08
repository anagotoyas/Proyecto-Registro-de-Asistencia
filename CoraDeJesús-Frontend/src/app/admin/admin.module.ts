import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AdminRoutingModule } from './admin-routing.module';
import { HomeAdmComponent } from './home-adm/home-adm.component';
import { LayoutComponent } from './layout/layout.component';
import { VerAsistenciaComponent } from './asistencia/ver-asistencia/ver-asistencia.component';
import { ElegirAsistenciaComponent } from './asistencia/elegir-asistencia/elegir-asistencia.component';
import { MatCardModule } from '@angular/material/card';
import { MatTableModule } from '@angular/material/table';
import { MatSelectModule } from '@angular/material/select';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    HomeAdmComponent,
    LayoutComponent,
    VerAsistenciaComponent,
    ElegirAsistenciaComponent
  ],
  imports: [
    CommonModule,
    AdminRoutingModule,
    MatCardModule,
    MatTableModule,
    MatSelectModule,
    FormsModule
  ]
})
export class AdminModule { }
