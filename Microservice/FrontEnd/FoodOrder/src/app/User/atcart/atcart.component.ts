import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { AddToCart } from 'src/app/add-to-cart';
import { Food } from 'src/app/food';
import { FoodServiceService } from 'src/app/food-service.service';

@Component({
  selector: 'app-atcart',
  templateUrl: './atcart.component.html',
  styleUrls: ['./atcart.component.css']
})
export class AtcartComponent implements OnInit
 {


   userId!:number;
   foodId!:number;


   atc:AddToCart[]=[];
   food: Food = new Food;





   constructor(private activeRouter:ActivatedRoute,private foodservice:FoodServiceService)
   {
     
   }
  ngOnInit(): void {
    this.activeRouter.params.subscribe(params => {
      
      this.userId=params['userdId'];
      this.foodId=params['foodId'];


      
    });

    // this.foodservice.getFoodById(this.foodId).subscribe(
    //   (data)=>{this.atc.push(data)},
    //   (error)=>{alert("cant add");}

    // )

    






  }




  















}
