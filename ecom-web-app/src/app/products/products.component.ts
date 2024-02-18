import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {ProductService} from "../services/product.service";
import {ProductModel} from "../model/product.model";

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {
  products !: ProductModel[]
  //products: any
  errorMessage!: string

  constructor(private productService:ProductService,
              private http:HttpClient) { }

  ngOnInit(): void {
    this.handleProducts()

    /*this.http.get("http://localhost:9999/inventory-service/products").subscribe({
      next:(data)=>{
        this.products=data
      },
      error:err => {}
    });*/
  }
  public handleProducts(){
    this.productService.getProducts().subscribe({
      next:data =>{
        this.products=data
      },
      error:err => {
        this.errorMessage=err.message
      }
    });
  }
}
