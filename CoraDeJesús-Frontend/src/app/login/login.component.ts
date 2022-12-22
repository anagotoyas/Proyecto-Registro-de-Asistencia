import { Component, OnInit} from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from './shared/login.service';
import { Login } from './shared/Usuario.model';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  usuario=new Login();
  id: any;
  msg:string="" //pueden usarlo paga un mensaje de error

  constructor(
    private loginService:LoginService,
    private router:Router){}
  ngOnInit():void{}
  logIn(){
    if(this.usuario.idUsuario==null || this.usuario.clave==null){
      console.log("Error, debe llenar todos los campos")
    }
    else{
      this.loginService.login(this.usuario).subscribe(
        (res:any)=>{
          localStorage.setItem('userSesion',JSON.stringify(res.dato))
          this.id = res.dato.idUsuario;
          sessionStorage.setItem('idUsuario', this.id)
          
          if(res.dato.rol.idRol==1){
            this.router.navigateByUrl('estud')
          }
          else if(res.dato.rol.idRol==2){
            this.router.navigateByUrl('docente')
          }
          else if(res.dato.rol.idRol==3){
            this.router.navigateByUrl('admin')
          }
        }  //,                                        Esto tambien es parte de caputa de errores
        // err => {
        //   console.log(err);
        //   this.msg="Credenciales incorrectas, porfavor ingrese correctamente sus datos";
        // }
      )
    }
  }


}
