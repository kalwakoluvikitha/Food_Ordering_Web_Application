import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AddToCart } from 'src/app/add-to-cart';
import { Food } from 'src/app/food';
import { FoodServiceService } from 'src/app/food-service.service';
import { Restaurant } from 'src/app/restaurant';
import { RestaurentService } from 'src/app/restaurent.service';
import { UserService } from 'src/app/user.service';
import { CartIteam } from '../cart-iteam';

@Component({
  selector: 'app-viewbycategory',
  templateUrl: './viewbycategory.component.html',
  styleUrls: ['./viewbycategory.component.css']
})
export class ViewbycategoryComponent   implements OnInit{


  
arg0!:string;

food:Food[]=[];

restaurant:Restaurant[]=[];
restId!:number;
userdId!:number;
  atc: AddToCart = new AddToCart;
  addedtcart: AddToCart = new AddToCart;
  AllCart:CartIteam[]=[];
  Display:Boolean=false;
  count!:number;


constructor(private activeroute:ActivatedRoute,private router :Router,private foodservice:FoodServiceService,
  private restaurantserice:RestaurentService,private userservice:UserService)
{

}



    ngOnInit(): void {
      this.activeroute.params.subscribe(params => {
        this.arg0 = params['arg0'];
        this.restId=params['restId'];
        this.userdId=params['userId'];
        console.log('rest Id:', this.arg0);
        console.log(this.restId);



      });


      if(this.restId==undefined)
      {


      this.foodservice.getByCategory(this.arg0).subscribe(
       (data)=>{this.food=data;},
       (error:any)=>{console.log(error);}


      );
      }
      else{
        this.foodservice.getFood(this.restId).subscribe(
          (data)=>{this.food=data;},
          (error:any)=>{console.log(error);}
          );
  
        

       
      }

      this.restaurantserice.getRestaurant().subscribe(
       (data)=>{this.restaurant=data;},
       (error:any)=>{console.log(error);}

      );





      // this.userservice.getatcByUserId(this.userdId).subscribe(
      //   (data)=>{this.AllCart=data;},
      //   (error)=>{console.log("culdnt fetch");}
     
     
      //   );
      //   console.log(this.AllCart);



  
  }



  vegonly() {
     


    if(this.restId==undefined)
    {

      this.foodservice.getByFoodTypeAndCategory(this.arg0).subscribe(
        (data)=>{this.food=data;},
        (error)=>{console.log("couldnt fetch");}
 
     );

      
    }
else{
    this.foodservice.getByFoodType(this.restId).subscribe(
       (data)=>{this.food=data;},
       (error)=>{console.log("couldnt fetch");}

    );
}



    }

   
   add(foodId:number) {
         
      
    this.atc.foodId=foodId;
     
      console.log(foodId+" "+this.userdId);
       
      
       this.userservice.addtocart(this.atc,this.userdId).subscribe(
         (data)=>{this.addedtcart=data;},
         (error)=>{alert("counldnt add");}

       );
       console.log(this.addedtcart);
       console.log(this.userdId);
  //      console.log(this.addedtcart);
  this.userservice.getatcByUserId(this.userdId).subscribe(
    (data)=>{this.AllCart=data;
    console.log(data);
    console.log(this.AllCart);
    this.count=this.AllCart.length;
    },
    (error)=>{console.log("culdnt fetch");}
 
 
    );
    console.log(this.AllCart);
 
    
          this.Display = true;
         
   


  //  console.log(this.AllCart);

  
  



   // this.router.navigate(['addtocart',this.userdId]);
       
    }
   


    close() {
      this.Display=false;
      }
      

      viewcart() {
        
         this.router.navigate(['viewcart',this.userdId]);

        }



}

