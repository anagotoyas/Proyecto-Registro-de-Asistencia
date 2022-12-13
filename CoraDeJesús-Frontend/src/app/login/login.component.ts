import { Component, OnInit} from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from './shared/login.service';
// import { LoginService } from './shared/login.service';
import { Usuario } from './shared/usuario';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  usuario=new Usuario();

  constructor(
      private loginService:LoginService,
     private router:Router){}


  ngOnInit():void{

    
  }

  logIn(){
    if(this.usuario.idUsuario==null || this.usuario.claveUsuario==null){
      console.log("Error, debe llenar todos los campos")
    }
    else{ 
      this.loginService.login(this.usuario)
    }

  }


}
