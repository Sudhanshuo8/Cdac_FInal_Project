import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from './product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  gatId = sessionStorage.getItem('gatId');


  constructor(private httpClient: HttpClient) { }

  private baseURL1= "http://localhost:8080/product_list/"+ this.gatId;


  getProductList() : Observable<Product[]>{
    return this.httpClient.get<Product[]>(this.baseURL1);
  }

}
