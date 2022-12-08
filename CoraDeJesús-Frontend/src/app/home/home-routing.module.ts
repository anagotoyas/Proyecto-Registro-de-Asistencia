import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from '../login/login.component';
import { IndexComponent } from './index/index.component';
import { LayoutComponent } from './layout/layout.component';

const routes: Routes = [
  {
    path:'',
    component: LayoutComponent,
    children:[
      {
        path:'',
        component:IndexComponent,
      },
      {
        path:"login",
        component:LoginComponent,
      }
    ],
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class HomeRoutingModule { }
