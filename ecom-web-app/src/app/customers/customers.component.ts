import { Component, OnInit } from '@angular/core';
import {Customer} from "../model/customer";
import {CustomerService} from "../services/customer.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-customers',
  templateUrl: './customers.component.html',
  styleUrls: ['./customers.component.css']
})
export class CustomersComponent implements OnInit {
  customers !: Customer[]
  messageError!:string

  constructor(private customerService:CustomerService,
              private router:Router) {
  }

  ngOnInit(): void {
    this.handleCustomer();
  }

  public handleCustomer(){
    this.customerService.getCustomers().subscribe({
      next:(data)=>{
        this.customers=data
      },
      error:err => {this.messageError=err.message}
    })
  }

  handleOrder(c: Customer) {
    this.router.navigateByUrl("/orders/"+c.id);
  }
}
