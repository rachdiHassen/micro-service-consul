import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  constructor(private http:HttpClient) { }

  public getOrder (customerId:number){
    //first line if we work with spring data rest
    //this.http.get("http://localhost:9999/order-service/orders/search/byCustomerId?customerId="+this.customerId)
    return this.http.get("http://localhost:9999/order-service/orderByCustomerId/"+customerId)
  }
}
