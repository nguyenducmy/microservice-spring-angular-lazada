import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import {HomeComponent} from "./pages/home/home.component";
import {RouterOutlet} from "@angular/router";
import {HeaderComponent} from "./component/header/header.component";
import {FormsModule} from "@angular/forms";
import {AppRoutingModule} from "./app-routing.module";
import {LoginComponent} from "./pages/login/login.component";
import { MainBannerComponent } from './component/main-banner/main-banner.component';
import { ProductComponent } from './component/product/product.component';
import {HttpClient, HttpClientModule} from "@angular/common/http";
import { SignupComponent } from './pages/signup/signup.component';


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    HeaderComponent,
    MainBannerComponent,
    ProductComponent,
    SignupComponent
  ],
  imports: [
    AppRoutingModule,
    BrowserModule,
    RouterOutlet,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
