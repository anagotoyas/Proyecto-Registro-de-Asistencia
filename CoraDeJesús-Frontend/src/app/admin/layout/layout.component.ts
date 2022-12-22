import { Component, OnInit } from '@angular/core';
import { Admin } from '../shared/admin';
import { AdminService } from '../shared/admin.service';

@Component({
  selector: 'app-layout',
  templateUrl: './layout.component.html',
  styleUrls: ['./layout.component.css']
})
export class LayoutComponent implements OnInit{
  admin:Admin;
  nombres: string;
  idUsuario=Number(sessionStorage.getItem('idUsuario'))

  constructor(
    private adminService: AdminService,
  ){}

  ngOnInit():void{
    this.obtenerDatos();
  }

  obtenerDatos(){
    this.adminService.getDatosOfAdmin(this.idUsuario).subscribe((data:any) => {
      console.log(this.idUsuario);
      
      this.admin = data["dato"];
      this.nombres = this.admin.nombre + ' ' + this.admin.apellidoPaterno + ' ' + this.admin.apellidoMaterno    
      
      console.log(this.admin);
      
    })
  }

}
