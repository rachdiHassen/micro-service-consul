import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class OrderDetailsService {

  constructor(private http:HttpClient) { }
   public getOrderDetails (orderId:number){
    return this.http.get("http://localhost:9999/order-service/fullOrder/"+orderId)
   }
}
