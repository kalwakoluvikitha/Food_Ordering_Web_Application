import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FoodServiceService {


  private apiUrl = 'http://localhost:8082/food/';



  constructor(private http:HttpClient) { }




  getFoodById(foodId:number):Observable<any>
  {
       return this.http.get(this.apiUrl+`${foodId}`);
  }


  getFood(restId:Number):Observable<any>
{
  console.log(restId);
   //return this.http.get(`${this.apiUrl}restaurant/${restId}`);
   return this.http.get(this.apiUrl+"restaurant/"+`${restId}`);
  }


  addfood(data:any):Observable<any>{

    console.log(data);
    return this.http.post(this.apiUrl,data);
    
      }

   getAllFood():Observable<any>{
    
    return this.http.get(this.apiUrl);
   }


    getAllCategory():Observable<any>{
      return this.http.get(this.apiUrl+"uniqueCategory");
    }



    getCategoryWithImage():Observable<any>{
      return this.http.get(this.apiUrl+"getCategory");
    }


    getByCategory(category:string):Observable<any>{
      const params = new HttpParams().set('category', category);
      return this.http.get<string>(`${this.apiUrl}category/`, { params });
    }


  getByFoodType(restId:number):Observable<any>{
    return this.http.get(this.apiUrl+"pureveg/"+`${restId}`);
  }

  getByFoodTypeAndCategory(category:string):Observable<any>{
    const params = new HttpParams().set('category', category);
    return this.http.get<string>(`${this.apiUrl}pureveg`, { params });
  }



}
