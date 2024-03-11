import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RestaurentService {

  private apiUrl = 'http://localhost:8081/restaurant/'; // Replace with your API URL





  constructor(private http:HttpClient) { }




  getRestaurant():Observable<any>  {

  return this.http.get(this.apiUrl);

  }
 
 
  addRestaurent(data:any):Observable<any>{
console.log(data);
return this.http.post(this.apiUrl,data);

  }

}
