import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {HomeComponent} from './components/Pages/home/home.component';
import {LoginComponent} from './components/Pages/login/login.component';
import {PartnerInfoComponent} from './components/Pages/partner-info/partner-info.component';
import {AddProductComponent} from "./components/Pages/add-product/add-product.component";
import {EditProductComponent} from "./components/Pages/edit-product/edit-product.component";

const routes: Routes =
[
  {path: '', component: HomeComponent},
  {path: 'login', component: LoginComponent},
  {path: 'home', component: HomeComponent},
  {path: 'partner-info', component: PartnerInfoComponent},
  {path: 'add-product', component: AddProductComponent},
  {path: 'edit-product', component: EditProductComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
