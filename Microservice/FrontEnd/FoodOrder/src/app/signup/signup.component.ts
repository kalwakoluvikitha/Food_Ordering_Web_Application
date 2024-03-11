import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { User } from '../user';
import { UserService } from '../user.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent    implements OnInit  {
  ngOnInit(): void {
   console.log(this.user);
  }

  constructor(private userservice:UserService)
  {

  }


  user: User = new User;

OnSubmit(forms:NgForm) {
console.log(forms);
console.log("hi");
this.user=forms.value;
console.log(this.user);
}


user1:User=new User;


addUser(){
  this.userservice.addUser(this.user).subscribe(
     (data)=>  {this.user1=data;},(error)=>{
      console.log("cannot register");
     }

  );
}





}
