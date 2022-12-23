import { Component } from '@angular/core';

@Component({
  selector: 'app-elegir-asistencia',
  templateUrl: './elegir-asistencia.component.html',
  styleUrls: ['./elegir-asistencia.component.css']
})
export class ElegirAsistenciaComponent {

  mover(idGrado:number){
    window.location.replace(`admin/${idGrado}/asistencia`);
  }

}