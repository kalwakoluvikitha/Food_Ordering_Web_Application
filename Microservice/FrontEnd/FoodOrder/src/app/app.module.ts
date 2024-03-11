import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { HomepageComponent } from './homepage/homepage.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { RestaurantComponent } from './restaurant/restaurant.component';
import { AddrestaurantComponent } from './addrestaurant/addrestaurant.component';
import { ViewFoodComponent } from './view-food/view-food.component';
import { AddfoodComponent } from './addfood/addfood.component';
import { MainpageComponent } from './User/mainpage/mainpage.component';
import { ViewbycategoryComponent } from './User/viewbycategory/viewbycategory.component';
import { AtcartComponent } from './User/atcart/atcart.component';
import { ViewcartComponent } from './User/viewcart/viewcart.component';
import { BillingaddressComponent } from './User/billingaddress/billingaddress.component';
import { OrderComponent } from './User/order/order.component';
import { ProfileComponent } from './User/profile/profile.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    SignupComponent,
    HomepageComponent,
    RestaurantComponent,
    AddrestaurantComponent,
    ViewFoodComponent,
    AddfoodComponent,
    MainpageComponent,
    ViewbycategoryComponent,
    AtcartComponent,
    ViewcartComponent,
    BillingaddressComponent,
    OrderComponent,
    ProfileComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
