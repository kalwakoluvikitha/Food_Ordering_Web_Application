import { Component, OnInit, ViewChild } from '@angular/core';
import { User } from '../user';
import { UserService } from '../user.service';
import { Observable } from 'rxjs';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent  implements OnInit{
  
  user: User = new User;
email:string="";
// submit(forms: NgForm) {
//   this.userservice.LoginUser(forms.value.email,forms.value.password).subscribe(
//     (data)=>{this.user=data;
//      this.route.navigate(['/users',this.user.userName]);
//    },
//     (error)=>{alert("please check details");}

//    );

// }
  user1: User = new User;

  username!:string;
  userId!:number;
OnSubmit(forms:NgForm
  ) {
     this.user1.email=forms.value.email;
     this.user1.password=forms.value.password;
     console.log(this.user1);
    this.userservice.LoginUser(this.user1).subscribe(
     (data)=>{this.user=data;
      this.username=this.user.userName;
      this.userId=this.user.userId;
      
      this.route.navigate(['user',this.username,this.userId]);
    },
     (error)=>{alert("please check details");}

    );


}




  
constructor(private userservice:UserService,private route :Router){
  console.log("hi");
  
 
}


  ngOnInit(): void {
      console.log(this.email);
      
      
  }


  getUsers(){
    this.userservice.getUser().subscribe(


      (data) => {
        this.user= data;
        console.log(this.user);
      },
      (error) => {
        console.error('Error fetching data:', error);
      }
    );
    
  }


  






  








}
