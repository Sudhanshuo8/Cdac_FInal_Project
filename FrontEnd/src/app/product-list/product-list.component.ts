import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Product } from '../product';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
  gatId = sessionStorage.getItem('gatId');

  products : Product[];

  constructor(private prodServ : ProductService ,  private router: Router) { }

  ngOnInit(): void {
    if (!sessionStorage.getItem('leaderSessionId')) {
      this.router.navigate(['login']);
    }
    this.GetProdcuts();
  }

  private GetProdcuts(){
    console.log("in function "+this.gatId);
    this.prodServ.getProductList().subscribe(data => {
      this.products = data;
    });
  }

  navigateToMemberReg()
  {
    //this.newgatId = this.gatId;
    //console.log(this.newgatId);
    console.log(this.gatId);
    this.router.navigate(['leader/memberReg']);
  }

  navigateToGatReg()
  {
    //this.newgatId = this.gatId;
    //console.log(this.newgatId);
    //console.log(this.gatId);
    this.router.navigate(['leader/gatReg']);
  }

  navigateToMemberList(){
    this.router.navigate(['leader/memberList']);

  }

  navigateToAddProduct()
  {
    this.router.navigate(['addProduct']);

  }

  navigateToProductList()
  {
    this.router.navigate(['products']);
  }

}
