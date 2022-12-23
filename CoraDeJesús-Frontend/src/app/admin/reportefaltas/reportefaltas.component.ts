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
    {value: 2018, viewValue: '2018'},
    {value: 2019, viewValue: '2019'},
    {value: 2020, viewValue: '2020'},
  ];

  bimestres= [
    {value: '2018-01', viewValue: '2018-01'},
    {value: '2018-03', viewValue: '2018-02'},
    {value: '2018-04', viewValue: '2018-03'},
    {value: '2018-05', viewValue: '2018-04'},
    {value: '2019-01', viewValue: '2019-01'},
    {value: '2019-03', viewValue: '2019-02'},
    {value: '2019-04', viewValue: '2019-03'},
    {value: '2019-05', viewValue: '2019-04'},
    {value: '2020-01', viewValue: '2020-01'},
    {value: '2020-02', viewValue: '2020-02'},
    {value: '2020-03', viewValue: '2020-03'},
  ];

  ngOnInit():void{
    console.log('a')
    this.generarReporte();
    

  }
  generarReporte(){
    console.log('generar reporte')
    console.log(this.bimestreValue, this.gradoValue)
    this.adminService.getFaltas(this.bimestreValue, this.gradoValue).subscribe(
      (data: any)=>{
        console.log(data);
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
