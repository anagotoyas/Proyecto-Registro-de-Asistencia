import { Component } from '@angular/core';

export interface PeriodicElement {
  name: string;
  position: number;
}

const ELEMENT_DATA: PeriodicElement[] = [
  {position: 1, name: 'Juanita Mendoza Escobar'},
  {position: 2, name: 'Laura Zapata Chavez'},
  {position: 3, name: 'Jairo Sanchez Núñez'},
  {position: 4, name: 'Taylor Alison Swift'},
  {position: 5, name: 'Abril Ramona Labin'},
  {position: 6, name: 'Elizabeth Grant Rey'},
  {position: 7, name: 'Joaquín Espinoza Vargas'},
  {position: 8, name: 'Piero Ramírez Farfán'},
  {position: 9, name: 'Jack Taehyung Kim'},
  {position: 10, name: 'Carly Rae Jepsen Perez'},
];


@Component({
  selector: 'app-ver-estudiantes',
  templateUrl: './ver-estudiantes.component.html',
  styleUrls: ['./ver-estudiantes.component.css']
})
export class VerEstudiantesComponent {

  displayedColumns: string[] = ['position', 'name'];
  dataSource = ELEMENT_DATA;

}
