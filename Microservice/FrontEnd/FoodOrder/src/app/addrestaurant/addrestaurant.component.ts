import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Restaurant } from '../restaurant';
import { RestaurentService } from '../restaurent.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-addrestaurant',
  templateUrl: './addrestaurant.component.html',
  styleUrls: ['./addrestaurant.component.css']
})
export class AddrestaurantComponent  implements OnInit {


  restaurant: Restaurant = new Restaurant;
  addedrest:Restaurant=new Restaurant;


constructor(private restservice:RestaurentService,private router:Router)
{

}






ngOnInit(): void {}

  
OnSubmit(forms: NgForm) {

  console.log(forms);
  // this.restaurant=forms.value;
   
  
  }
  

addrestaurant(forms:NgForm){
  console.log(forms);
  this.restaurant=forms.value;
   console.log(this.restaurant)
  this.restservice.addRestaurent(this.restaurant).subscribe(
   (data)=>{this.addedrest=data;},
   (error)=>{console.log("couldnt add");}

  );
  this.router.navigate(['admin']);
  
}



}
