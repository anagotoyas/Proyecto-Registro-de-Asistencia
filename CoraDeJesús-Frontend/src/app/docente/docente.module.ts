import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { DocenteRoutingModule } from './docente-routing.module';
import { HomeDocComponent } from './home-doc/home-doc.component';
import { VerEstudiantesComponent } from './asistencia/ver-estudiantes/ver-estudiantes.component';

import { MatTableModule } from '@angular/material/table';
import { VerDatosComponent } from './ver-datos/ver-datos.component';
import {MatSelectModule} from '@angular/material/select';
import { FormsModule } from '@angular/forms';
import { LayoutComponent } from './layout/layout.component';
import { IncidenciasComponent } from './asistencia/incidencias/incidencias.component';

@NgModule({
  declarations: [
    HomeDocComponent,
    VerEstudiantesComponent,
    VerDatosComponent,
    LayoutComponent,
    IncidenciasComponent
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
