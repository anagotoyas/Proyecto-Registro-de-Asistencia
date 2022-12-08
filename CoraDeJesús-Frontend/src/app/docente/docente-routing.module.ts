import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { RegistrarAsistenciaComponent } from './asistencia/registrar-asistencia/registrar-asistencia.component';
import { VerEstudiantesComponent } from './asistencia/ver-estudiantes/ver-estudiantes.component';
import { HomeDocComponent } from './home-doc/home-doc.component';
import { LayoutComponent } from './layout/layout.component';
import { VerDatosComponent } from './ver-datos/ver-datos.component';

const routes: Routes = [
  {
    path:'',
    component: LayoutComponent,
    children: [
      {
        path:'',
        component: HomeDocComponent,
      },
      {
        path: 'datos',
        component: VerDatosComponent,
      },
      {
        path: 'ver-estud',
        component: VerEstudiantesComponent,
      },
      {
        path: 'asistencia',
        component: RegistrarAsistenciaComponent,
      }
    ],
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DocenteRoutingModule { }
