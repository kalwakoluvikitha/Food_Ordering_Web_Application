import { Injectable } from '@angular/core';

import { Observable, catchError, throwError } from 'rxjs';
import { User } from './user';
import { HttpClient, HttpErrorResponse, HttpParams } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private apiUrl = 'http://localhost:8080/users/'; // Replace with your API URL





  constructor(private http:HttpClient) { }




  getUser():Observable<any>  {

  return this.http.get(this.apiUrl);

  }


  addUser(data:any):Observable<any>{

return this.http.post(this.apiUrl,data).pipe(
  catchError((error: HttpErrorResponse) => {
    // Handle the error and display the message to the user
    console.error('API Error:', error);
    const errorMessage = error.error.message || 'An error occurred. Please try again later.';
    // You can display the error message to the user using Angular's MatSnackBar, alert, or any other method
    alert(errorMessage);

    return throwError(errorMessage);
  })
);


















  }


  // LoginUser(email:string,password:string):Observable<any>{
  //   const params = new HttpParams().set('email',email).set('password',password);
  //   return this.http.get<string>(`${this.apiUrl}login/`, { params });
  // }

   LoginUser(data:any):Observable<any>{
    console.log(data);
    return this.http.post(this.apiUrl+"login",data);
  }


  addtocart(data:any,userId:number):Observable<any>{

    return this.http.post(this.apiUrl+"addtocart/"+`${userId}`,data);
  }

  getUserById(userId:number):Observable<any>
  {
    return this.http.get(this.apiUrl+`${userId}`);
  }

  getatcByUserId(userId:number):Observable<any>
  {
    return this.http.get(this.apiUrl+"cartbyuserId/"+`${userId}`);
  }


  increaseQuantity(addtocartId:number,quantity:number):Observable<any>
  {
      return this.http.get(this.apiUrl+"increasequantity/"+`${addtocartId}`+"/"+`${quantity}`);
  }


  decreaseQuantity(addtocartId:number,quantity:number):Observable<any>
  {
    return this.http.get(this.apiUrl+"decreasequantity/"+`${addtocartId}`+"/"+`${quantity}`);
  }

  deletecartbyId(addtocartId:number):Observable<any>
  {
    return this.http.delete(this.apiUrl+"deletecartiteam/"+`${addtocartId}`);
  }


  order(userId:number,address:string):Observable<any>
  {
    return this.http.post(this.apiUrl+"buyall/"+`${userId}`+"/"+`${address}`,null);
  }


  placedOrders(userId:number):Observable<any>
  {
    return this.http.get(this.apiUrl+"order/"+`${userId}`);
  }

  groupByOrders(userId:number):Observable<any>
  {
    return this.http.get(this.apiUrl+"gropubyorder/"+`${userId}`);
  }

}
