import { Component, OnInit } from '@angular/core';
import { Color, ScaleType } from '@swimlane/ngx-charts';
import {AdminService} from "../shared/admin.service";



@Component({
  selector: 'app-reportefaltas',
  templateUrl: './reportefaltas.component.html',
  styleUrls: ['./reportefaltas.component.css']
})


export class ReportefaltasComponent implements OnInit{
  single = [];


  gradoValue: number= 2022;
  bimestreValue: string= 'primero';


  grados = [
    {value: 2022, viewValue: 'Primero'},
    {value: 2022, viewValue: 'Segundo'},
    {value: 2022, viewValue: 'Tercero'},
    {value: 2022, viewValue: 'Cuarto'},
    {value: 2022, viewValue: 'Quinto'},
  ];

  bimestres= [
    {value: 'primero', viewValue: 'Primero'},
    {value: 'segundo', viewValue: 'Segundo'},
    {value: 'tercero', viewValue: 'Tercero'},
    {value: 'cuarto', viewValue: 'Cuarto'},
  ];

  ngOnInit():void{
    this.generarReporte();

  }
  generarReporte(){
    console.log(this.bimestreValue, this.gradoValue);
    this.adminService.getFaltas(this.bimestreValue, this.gradoValue).subscribe(
      (data: any)=>{
        this.single  = [];
        data.forEach(
          // @ts-ignore
          valor =>{
            // @ts-ignore
            this.single.push({name: valor[1], value:valor[0]});
          }
        )
      }, error => {
        console.log(error)
      }
    )
  }
  validoGuardar(): boolean{
    return this.bimestreValue == undefined || this.gradoValue == undefined;
  }


  view: [number, number] = [900, 400];

  // options
  gradient: boolean = true;
  showLegend: boolean = true;
  showLabels: boolean = true;
  isDoughnut: boolean = false;

  colorScheme: Color = {
    name: 'myScheme',
    selectable: true,
    group: ScaleType.Ordinal,
    domain: ['#f00', '#0f0', '#0ff'],
  };
  constructor(
    private adminService: AdminService
  ) {
    //Object.assign(this, { single });
  }

  onSelect(data: any): void {
    console.log('Item clicked', JSON.parse(JSON.stringify(data)));
  }

  onActivate(data: any): void {
    console.log('Activate', JSON.parse(JSON.stringify(data)));
  }

  onDeactivate(data: any): void {
    console.log('Deactivate', JSON.parse(JSON.stringify(data)));
  }
}
