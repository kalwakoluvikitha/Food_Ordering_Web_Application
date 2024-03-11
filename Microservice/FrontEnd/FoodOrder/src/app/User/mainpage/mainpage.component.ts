import { Component, OnInit } from '@angular/core';
import { Food } from 'src/app/food';
import { FoodServiceService } from 'src/app/food-service.service';
import { Category } from '../category';
import { ActivatedRoute, Router } from '@angular/router';
import { RestaurentService } from 'src/app/restaurent.service';
import { Restaurant } from 'src/app/restaurant';

@Component({
  selector: 'app-mainpage',
  templateUrl: './mainpage.component.html',
  styleUrls: ['./mainpage.component.css']
})
export class MainpageComponent  implements OnInit{



  
  food:Food[]=[];
  category:Category[]=[];
  username!:string;
  restaurants:Restaurant[]=[];
  userId!:number;
  dropmenu:boolean=false;

  items = Array.from({ length: 10 }, (_, i) => `Item ${i + 1}`);
  ngOnInit(): void {

    this.activateroute.params.subscribe(params => {
      this.username = params['username'];
      this.userId=params['userId'];
      console.log('rest Id:', this.username);
    });
   this.foodservice.getCategoryWithImage().subscribe(
    (data)=>{this.category=data;},
    (error)=>{console.log("counldnt fetch");}

   );


   this.restaurantservice.getRestaurant().subscribe(
        (data)=>{this.restaurants=data;},
        (error)=>{console.log("couldnt fetch");}

   );
    

   console.log(this.category);
   
  }


  constructor(private foodservice:FoodServiceService,private router:Router,private activateroute:ActivatedRoute,private restaurantservice:RestaurentService){

  }


  //view By category
  viewcategory(arg0: string) {
 
     console.log(arg0);

     this.router.navigate(['/viewbycategory',arg0,this.userId]);



  }
  onclick(restId: number) {
    this.router.navigate(['viewbyrestaurant',restId,this.userId]);
    }

    seeCart() {
     
          this.router.navigate(['/viewcart',this.userId]);
         

      }

      profile() {
         

        this.router.navigate(['/profile',this.userId]);

        }
        


}
