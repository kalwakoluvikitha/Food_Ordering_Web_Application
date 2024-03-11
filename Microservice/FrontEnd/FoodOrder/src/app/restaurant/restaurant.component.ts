import { Component, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import { RestaurentService } from '../restaurent.service';
import { Restaurant } from '../restaurant';
import { Food } from '../food';
import { Router } from '@angular/router';

@Component({
  selector: 'app-restaurant',
  templateUrl: './restaurant.component.html',
  styleUrls: ['./restaurant.component.css']
})
export class RestaurantComponent implements OnInit,OnChanges {


  ngOnInit(): void {
    this.restaurantservice.getRestaurant().subscribe(
      (data)=>{
        this.restaurant=data;
         

        console.log(this.restaurant);
      },
      (error)=>{
        console.log("coudnt able to load");
      }
      


    );
    
  }


  constructor(private restaurantservice:RestaurentService,private router:Router){

  }
  ngOnChanges(changes: SimpleChanges): void {
    
  }


  restaurant:Restaurant[]=[];
  food: Food = new Food;

  // getRestaurant()
  // {
  //   this.restaurantservice.getRestaurant().subscribe(
  //     (data)=>{
  //       this.restaurant=data;
         

  //       console.log(this.restaurant);
  //     },
  //     (error)=>{
  //       console.log("coudnt able to load");
  //     }
      


  //   );
  // }

  addrestaurant() {
  console.log("hi");
    this.router.navigate(['../addrestaurant']);

  }


  viewmore(arg0: number) {
    
    this.router.navigate(['/viewmore',arg0]);
    }

}

