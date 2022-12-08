import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { DocenteRoutingModule } from './docente-routing.module';
import { HomeDocComponent } from './home-doc/home-doc.component';
import { VerEstudiantesComponent } from './asistencia/ver-estudiantes/ver-estudiantes.component';
import { RegistrarAsistenciaComponent } from './asistencia/registrar-asistencia/registrar-asistencia.component';
import { MatTableModule } from '@angular/material/table';
import { VerDatosComponent } from './ver-datos/ver-datos.component';
import {MatSelectModule} from '@angular/material/select';
import { FormsModule } from '@angular/forms';
import { LayoutComponent } from './layout/layout.component';

@NgModule({
  declarations: [
    HomeDocComponent,
    VerEstudiantesComponent,
    RegistrarAsistenciaComponent,
    VerDatosComponent,
    LayoutComponent
  ],
  imports: [
    CommonModule,
    DocenteRoutingModule,
    MatTableModule,
    MatSelectModule,
    FormsModule
  ]
})
export class DocenteModule { }
