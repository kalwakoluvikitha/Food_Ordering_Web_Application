import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FoodServiceService } from '../food-service.service';
import { Food } from '../food';

@Component({
  selector: 'app-view-food',
  templateUrl: './view-food.component.html',
  styleUrls: ['./view-food.component.css']
})
export class ViewFoodComponent  implements OnInit{



  args0!:number;
  food:Food[]=[];
  category:string[]=[];
  type:string[]=[];


  constructor(private route:ActivatedRoute,private foodservice:FoodServiceService,private router:Router){
   
   

  }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.args0 = params['arg0'];
      console.log('rest Id:', this.args0);
    });


    this.foodservice.getFood(this.args0).subscribe(

      (data)=>{this.food=data
        console.log(this.food);
       
        ;},
      (error)=>{console.error("cant fetch");}
    );



    for (let i = 0; i < this.food.length; i++) {
         this.category.push(this.food[i].category.toLowerCase());
    }

  }
     


  
  addfood() {
    
         this.router.navigate(['addFood',this.args0]);

    }





  }


  
   




