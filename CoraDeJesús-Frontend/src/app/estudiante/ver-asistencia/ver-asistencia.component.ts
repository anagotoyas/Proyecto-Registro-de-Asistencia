import { Component } from '@angular/core';
import { Asistencia } from '../shared/asistencia.model';

const DATA_SIMULADA: Asistencia[] = [
  {nombreAsistencia: 'Asistencia', fecha: '14/08/2022'},
  {nombreAsistencia: 'Tardanza', fecha: '13/08/2022'},
  {nombreAsistencia: 'Asistencia', fecha: '12/08/2022'},
  {nombreAsistencia: 'Asistencia', fecha: '11/08/2022'},
  {nombreAsistencia: 'Tardanza', fecha: '10/08/2022'},
  {nombreAsistencia: 'Tardanza Justificada', fecha: '07/08/2022'},
  {nombreAsistencia: 'Inasistencia', fecha: '06/08/2022'},
];

@Component({
  selector: 'app-ver-asistencia',
  templateUrl: './ver-asistencia.component.html',
  styleUrls: ['./ver-asistencia.component.css']
})

export class VerAsistenciaComponent {

  displayedColumns: string[] = ['nombreAsistencia', 'fecha'];
  dataSource = DATA_SIMULADA;

}
