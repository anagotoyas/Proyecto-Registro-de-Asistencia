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
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ReporteAsistenciasComponent } from './reporte-asistencias/reporte-asistencias.component';
import { ReportefaltasComponent } from './reportefaltas/reportefaltas.component';
import {NgxChartsModule} from "@swimlane/ngx-charts";
import {MatButtonModule} from "@angular/material/button";
import { HttpClientModule } from '@angular/common/http';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatInputModule} from '@angular/material/input';

@NgModule({
  declarations: [
    HomeAdmComponent,
    LayoutComponent,
    VerAsistenciaComponent,
    ElegirAsistenciaComponent,
    ReporteAsistenciasComponent,
    ReportefaltasComponent
  ],
  imports: [
    CommonModule,
    AdminRoutingModule,
    MatCardModule,
    MatTableModule,
    MatSelectModule,
    FormsModule,
    NgxChartsModule,
    MatButtonModule,
    HttpClientModule,
    MatDatepickerModule,
    ReactiveFormsModule,
    MatInputModule
  ]
})
export class AdminModule { }
