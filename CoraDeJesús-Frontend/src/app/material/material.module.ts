import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatFormFieldModule } from '@angular/material/form-field';
import { VerAsistenciaComponent } from '../estudiante/ver-asistencia/ver-asistencia.component';



@NgModule({
  declarations: [
   
  ],
  imports: [
    CommonModule,
    MatFormFieldModule,
  
  ],
  exports: [
    MatFormFieldModule
  ]
})
export class MaterialModule { }
