import { Component } from '@angular/core';
import { Food } from '../food';
import { ActivatedRoute, Router } from '@angular/router';
import { FoodServiceService } from '../food-service.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-addfood',
  templateUrl: './addfood.component.html',
  styleUrls: ['./addfood.component.css']
})
export class AddfoodComponent {








  args0!:number;
  food: Food = new Food;
  category:string[]=[];
  type:string[]=[];


  constructor(private route:ActivatedRoute,private foodservice:FoodServiceService,private router:Router){
   
   

  }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.args0 = params['arg0'];
      console.log('rest Id:', this.args0);
    });
    this.food.restId=this.args0;

     
}

food1!:Food;

OnSubmit(form: NgForm) {
  console.log(form);
  this.food=form.value;
  this.addfood();
  
  }


addfood() {
  this.food.restId=this.args0;
  console.log(this.food);
  this.foodservice.addfood(this.food).subscribe(
  (data)=>{this.food1=data;},
  (error)=>{console.log("couldnt add");}
  );


  this.router.navigate(['admin']);
  }


}
