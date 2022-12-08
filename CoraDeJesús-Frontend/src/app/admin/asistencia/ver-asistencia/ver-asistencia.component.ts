import { Component } from '@angular/core';

export interface PeriodicElement {
  name: string;
  position: number;
  status: string;
}

interface Food {
  value: string;
  viewValue: string;
}

const ELEMENT_DATA: PeriodicElement[] = [
  {position: 1, name: 'Juanita Mendoza Escobar', status: 'Asistencia'},
  {position: 2, name: 'Laura Zapata Chavez', status: 'Asistencia'},
  {position: 3, name: 'Jairo Sanchez Núñez', status: 'Asistencia'},
  {position: 4, name: 'Taylor Alison Swift', status: 'Asistencia'},
  {position: 5, name: 'Abril Ramona Labin', status: 'Asistencia'},
  {position: 6, name: 'Elizabeth Grant Rey', status: 'Tardanza'},
  {position: 7, name: 'Joaquín Espinoza Vargas', status: 'Asistencia'},
  {position: 8, name: 'Piero Ramírez Farfán', status: 'Asistencia'},
  {position: 9, name: 'Jack Taehyung Kim', status: 'Falta'},
  {position: 10, name: 'Carly Rae Jepsen Perez', status: 'Asistencia'},
];

@Component({
  selector: 'app-ver-asistencia',
  templateUrl: './ver-asistencia.component.html',
  styleUrls: ['./ver-asistencia.component.css']
})
export class VerAsistenciaComponent {

  selected: any;

  foods: Food[] = [
    {value: 'steak-0', viewValue: 'Steak'},
    {value: 'pizza-1', viewValue: 'Pizza'},
    {value: 'tacos-2', viewValue: 'Tacos'},
  ];

  displayedColumns: string[] = ['position', 'name', 'status'];
  dataSource = ELEMENT_DATA;

  ELEMENT_DATA: PeriodicElement[] = [
    {position: 1, name: 'Juanita Mendoza Escobar', status: 'Asistencia'},
    {position: 2, name: 'Laura Zapata Chavez', status: 'Asistencia'},
    {position: 3, name: 'Jairo Sanchez Núñez', status: 'Asistencia'},
    {position: 4, name: 'Taylor Alison Swift', status: 'Asistencia'},
    {position: 5, name: 'Abril Ramona Labin', status: 'Asistencia'},
    {position: 6, name: 'Elizabeth Grant Rey', status: 'Tardanza'},
    {position: 7, name: 'Joaquín Espinoza Vargas', status: 'Asistencia'},
    {position: 8, name: 'Piero Ramírez Farfán', status: 'Asistencia'},
    {position: 9, name: 'Jack Taehyung Kim', status: 'Falta'},
    {position: 10, name: 'Carly Rae Jepsen Perez', status: 'Asistencia'},
  ];

}
