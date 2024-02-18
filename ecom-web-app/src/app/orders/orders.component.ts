import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {OrderService} from "../services/order.service";
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.css']
})
export class OrdersComponent implements OnInit {
  customerId!:number
  orders :any
  constructor(private route:ActivatedRoute,
              private router:Router,
              private orderService:OrderService) {
    this.customerId=this.route.snapshot.params['customerId']
  }

  ngOnInit(): void {
    this.handleOrderByCustomer()
  }

  public handleOrderByCustomer (){
    this.orderService.getOrder(this.customerId).subscribe({
      next:(data)=>{
        this.orders=data
      },
      error:err => {}
    })
  }

  handleOrderDetails(o: any) {
    this.router.navigateByUrl("/orderDetails/"+o.id)
  }
}
