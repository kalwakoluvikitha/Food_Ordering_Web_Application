import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from 'src/app/user';
import { UserService } from 'src/app/user.service';
import { PlacedOrders } from '../placed-orders';
import { GropByOrder } from '../grop-by-order';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit{
OnSubmit(_t25: NgForm) {
throw new Error('Method not implemented.');
}
  

  order:boolean=false;
  edit:boolean=false;
  home:boolean=false;
   user!:User;
   userId!:number;
   placed:PlacedOrders[]=[];
   group:GropByOrder[]=[];



  constructor(private router:Router,private userservice:UserService,private activate:ActivatedRoute)
  {}
ngOnInit(): void {
  this.activate.params.subscribe(params => {
    this.userId= params['userId'];
  });


  this.userservice.getUserById(this.userId).subscribe(
    (data)=>{this.user=data;},
    (error)=>{console.log("couldnt fetch");}

  );
  this.userservice.placedOrders(this.userId).subscribe(
    (data)=>{this.placed=data;},
    (error)=>{console.log("couldnt fetch");}



  );
  this.userservice.groupByOrders(this.userId).subscribe(
  (data)=>{this.group=data;},
  (error)=>{console.log("Couldnt fetch");}


  );


}


  
navigateTo(arg0: string) {
  if(arg0==='order')
  {
    this.order=!this.order;
    this.edit=false;
    



  }
  if(arg0==='edit')
  {
    this.edit=!this.edit;
    this.order=false;
  }





}

}
