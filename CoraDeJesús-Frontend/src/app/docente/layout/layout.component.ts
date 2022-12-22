import { Component } from '@angular/core';
import { DocenteService } from '../shared/docente.service';

@Component({
  selector: 'app-layout',
  templateUrl: './layout.component.html',
  styleUrls: ['./layout.component.css']
})
export class LayoutComponent {

  constructor(public docenteService: DocenteService) { }

  nombre: any;

  ngOnInit(): void {

    const id = localStorage.getItem('idTutor');

    this.docenteService.obtenerTutorPorId(id).subscribe((data:any) => {
      
      this.nombre = data['dato'].nombre
      
    })
  }

}
