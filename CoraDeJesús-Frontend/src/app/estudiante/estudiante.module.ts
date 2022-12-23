import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { EstudianteRoutingModule } from './estudiante-routing.module';
import { HomeEstComponent } from './home-est/home-est.component';
import { LayoutComponent } from './layout/layout.component';
import { VerAsistenciaComponent } from './ver-asistencia/ver-asistencia.component';
import { VerDatosComponent } from './ver-datos/ver-datos.component';
import { MatTableModule } from '@angular/material/table';
import { ElegirAsistenciaComponent } from './elegir-asistencia/elegir-asistencia.component';
import { MatFormField, MatFormFieldModule } from '@angular/material/form-field';
import { MatSelect, MatSelectModule } from '@angular/material/select';
import { MatOption, MatOptionModule } from '@angular/material/core';
import { MaterialModule } from '../material/material.module';


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
    MatTableModule,
    MatSelectModule,
    MatOptionModule
    
  ],
  
})
export class EstudianteModule { }
