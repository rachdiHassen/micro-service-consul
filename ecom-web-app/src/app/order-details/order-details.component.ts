import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {OrderService} from "../services/order.service";
import {OrderDetailsService} from "../services/order-details.service";

@Component({
  selector: 'app-order-details',
  templateUrl: './order-details.component.html',
  styleUrls: ['./order-details.component.css']
})
export class OrderDetailsComponent implements OnInit {
  orderId!:number
  orderDetails :any
  constructor(private route:ActivatedRoute,
              private orderDetailsService:OrderDetailsService) {
    this.orderId=this.route.snapshot.params['orderId']
  }

  ngOnInit(): void {
    this.handleOrderDetails()
  }

  public handleOrderDetails (){
    this.orderDetailsService.getOrderDetails(this.orderId).subscribe({
      next:(data)=>{
        this.orderDetails=data
      },
      error:err => {}
    })
  }

}
