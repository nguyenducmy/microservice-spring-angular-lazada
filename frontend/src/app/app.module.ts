import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {HeaderComponent} from './components/header/header.component';
import {SideMenuComponent} from './components/side-menu/side-menu.component';
import {FooterComponent} from './components/footer/footer.component';
import {TopNavigationComponent} from './components/top-navigation/top-navigation.component';
import {MenuFooterButtonComponent} from './components/menu-footer-button/menu-footer-button.component';
import {HomeComponent} from './components/Pages/home/home.component';
import {PartnerInfoComponent} from './components/Pages/partner-info/partner-info.component';
import {LatestBrochureComponent} from './components/Pages/latest-brochure/latest-brochure.component';
import {SignedRepoComponent} from './components/Pages/signed-repo/signed-repo.component';
import {LeadsFromCorsivaComponent} from './components/Pages/leads-from-corsiva/leads-from-corsiva.component';
import {LeadsToCorsivaComponent} from './components/Pages/leads-to-corsiva/leads-to-corsiva.component';
import {LoginComponent} from './components/Pages/login/login.component';
import { AddProductComponent } from './components/Pages/add-product/add-product.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    SideMenuComponent,
    FooterComponent,
    TopNavigationComponent,
    MenuFooterButtonComponent,
    HomeComponent,
    PartnerInfoComponent,
    LatestBrochureComponent,
    SignedRepoComponent,
    LeadsFromCorsivaComponent,
    LeadsToCorsivaComponent,
    LoginComponent,
    AddProductComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
