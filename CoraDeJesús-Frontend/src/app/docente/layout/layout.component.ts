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
 
  idUsuario=Number(sessionStorage.getItem('idUsuario'))

  ngOnInit(): void {

    const id = localStorage.getItem('idTutor');

    this.obtenerDatos(sessionStorage.getItem('idUsuario'));
  }

  obtenerDatos(id:any){
    this.docenteService.getUsuarioPorId(id).subscribe((data:any) => {
      console.log(this.idUsuario);
      
      
      this.nombre = data.dato.nombre + ' ' + data.dato.apellidoPaterno + ' ' + data.dato.apellidoMaterno    
      
      
      
    })
  }

  

}
