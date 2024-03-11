import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomepageComponent } from './homepage/homepage.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
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

const routes: Routes = [{path:'',component:LoginComponent},{path:'home',component:HomepageComponent},
{path:'login',component:LoginComponent},
{path:'signup',component:SignupComponent},
{path:'admin',component:RestaurantComponent},
{path:'addrestaurant',component:AddrestaurantComponent},
{path:'viewmore/:arg0',component:ViewFoodComponent},
{path:'addFood/:arg0',component:AddfoodComponent},
{path:'user/:username/:userId',component:MainpageComponent},
{path:'viewbycategory/:arg0/:userId',component:ViewbycategoryComponent},
{path:'viewbyrestaurant/:restId/:userId',component:ViewbycategoryComponent},
{path:'addtocart/:userdId',component:AtcartComponent},
{path:'viewcart/:userId',component:ViewcartComponent},
{path:'billingaddress/:userId',component:BillingaddressComponent},
{path:'order/:userId/:address',component:OrderComponent},
{path:'profile/:userId',component:ProfileComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
