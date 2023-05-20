import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/Pages/home/home.component';
import { LoginComponent } from './components/Pages/login/login.component';
import { PartnerInfoComponent } from './components/Pages/partner-info/partner-info.component';

const routes: Routes = 
[ 
  {path: '', component: HomeComponent},
  {path: 'login', component: LoginComponent},
  {path: 'home', component: HomeComponent},
  {path: 'partner-info', component: PartnerInfoComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
