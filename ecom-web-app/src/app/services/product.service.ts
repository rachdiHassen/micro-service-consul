import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {ProductModel} from "../model/product.model";

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private http:HttpClient) { }

  public getProducts():Observable<Array<ProductModel>>{
    return this.http.get<ProductModel[]>("http://localhost:9999/inventory-service/listProduct")
  }
}
