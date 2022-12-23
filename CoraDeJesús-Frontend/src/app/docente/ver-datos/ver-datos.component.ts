import { Component } from '@angular/core';
import { DocenteService } from '../shared/docente.service';
import { Tutor } from '../shared/tutor';

@Component({
  selector: 'app-ver-datos',
  templateUrl: './ver-datos.component.html',
  styleUrls: ['./ver-datos.component.css']
})
export class VerDatosComponent {

  tutor: Tutor
  nombres:string;
  idUsuario=Number(sessionStorage.getItem('idUsuario'))

  constructor(private docenteService: DocenteService) { }

  ngOnInit(): void {
    this.obtenerDatos();

  }

  obtenerDatos(){
    this.docenteService.obtenerTutorPorId(this.idUsuario).subscribe((data:any) => {
      
      this.tutor = data["dato"];
      this.nombres = this.tutor.nombre + ' ' + this.tutor.apellidoPaterno + ' ' + this.tutor.apellidoMaterno    
    
      
    })
  }

}
