import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Route, Router } from '@angular/router';
import { User } from 'src/app/user';
import { UserService } from 'src/app/user.service';

@Component({
  selector: 'app-billingaddress',
  templateUrl: './billingaddress.component.html',
  styleUrls: ['./billingaddress.component.css']
})
export class BillingaddressComponent  implements OnInit{



   userId!:number;
   user: User = new User;
   address!:string;


   constructor(private activaterouter:ActivatedRoute,private userservice:UserService,private router:Router)
   {

   }


  ngOnInit(): void {
    this.activaterouter.params.subscribe(params => {
      this.userId= params['userId'];
    });
    this.userservice.getUserById(this.userId).subscribe(
      (data)=>{this.user=data;},
      (error)=>{console.log("couldnt fetch");}
    );
    this.address=this.user.address;


  }
   

  useraddress() {
    

    this.address=this.user.address;
    console.log(this.address);

    }

    order(){
     if(this.address==null)
     {
      alert("Please select address");
     }

     console.log(this.address);

     this.router.navigate(['order',this.userId,this.address]);


    }




}
