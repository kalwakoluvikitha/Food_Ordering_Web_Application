import { Component, OnDestroy, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from 'src/app/user';
import { UserService } from 'src/app/user.service';
import { Order } from '../order';
import { FoodServiceService } from 'src/app/food-service.service';
import { DatePipe } from '@angular/common';
import { Food } from 'src/app/food';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit {
back() {
  this.router.navigate(['user',this.user.userName,this.userId]);
}



  userId!:number;
  user: User = new User;
  address!:string;
  order!:Order;
  myDate:Date= new Date();
  food:Food[]=[];
  

  constructor(private activaterouter:ActivatedRoute,private userservice:UserService,private router:Router,private foodservice:FoodServiceService)
  {
    
  }


 ngOnInit(): void {
   this.activaterouter.params.subscribe(params => {
     this.userId= params['userId'];
     this.address=params['address'];

   });
   this.userservice.getUserById(this.userId).subscribe(
     (data)=>{this.user=data;},
     (error)=>{console.log("couldnt fetch");}
   );
   
   this.userservice.order(this.userId,this.address).subscribe(
     (data)=>{this.order=data;},
     (error)=>{console.log("couldnt get");}


   );
   this.foodservice.getAllFood().subscribe(
   (data)=>{this.food=data;},
   (error)=>{console.log("food cant be fetched");}

   );
   console.log(this.order);


 }

 

 
 



}
