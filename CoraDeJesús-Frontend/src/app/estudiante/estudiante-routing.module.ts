import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeEstComponent } from './home-est/home-est.component';
import { LayoutComponent } from './layout/layout.component';
import { VerAsistenciaComponent } from './ver-asistencia/ver-asistencia.component';
import { VerDatosComponent } from './ver-datos/ver-datos.component';

const routes: Routes = [
  {
    path:'',
    component: LayoutComponent,
    children: [
      {
        path:'',
        component: HomeEstComponent,
      },
      {
        path:'datos',
        component: VerDatosComponent,
      },
      {
        path:'asistencia',
        component: VerAsistenciaComponent,
      },
    ],
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class EstudianteRoutingModule { }
