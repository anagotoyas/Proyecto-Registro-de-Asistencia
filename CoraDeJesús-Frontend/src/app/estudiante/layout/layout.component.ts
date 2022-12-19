import { Component,OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Estudiante } from '../shared/Estudiante.model';

@Component({
  selector: 'app-layout',
  templateUrl: './layout.component.html',
  styleUrls: ['./layout.component.css']
})
export class LayoutComponent implements OnInit {

  estudiante:Estudiante;

  constructor(private router:Router){
    let strg=localStorage.getItem('userSesion')
    if(strg=="" || strg==null){
      router.navigateByUrl("login")
    }
    else{
      this.estudiante=JSON.parse(strg)
    }
  }
  ngOnInit():void{
  }

}
