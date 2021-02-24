import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Member } from '../member';
import * as $ from 'jquery';
import { PlatformLocation } from '@angular/common'; 

@Component({
  selector: 'app-leader',
  templateUrl: './leader.component.html',
  styleUrls: ['./leader.component.css']
})
export class LeaderComponent implements OnInit {

  leadId = sessionStorage.getItem('leadId');
  gatId = sessionStorage.getItem('gatId');

  newgatId = sessionStorage.getItem('gatId');

  constructor(private router : Router,location: PlatformLocation) { 
    location.onPopState(() => {
      console.log('pressed back in add!!!!!');
      this.router.navigate(['leader']);
      history.forward();
      });
  }

  ngOnInit(): void {
    $("#menu-toggle").click(function(e) {
      e.preventDefault();
      $("#wrapper").toggleClass("toggled");
    });



    if (!sessionStorage.getItem('leaderSessionId')) {
      this.router.navigate(['login']);
    }
  }

  navigateToMemberReg()
  {
    //this.newgatId = this.gatId;
    console.log(this.newgatId);
    console.log(this.gatId);
    this.router.navigate(['leader/memberReg']);
  }

  navigateToAddProduct()
  {
    this.router.navigate(['addProduct']);

  }

  navigateToProductList()
  {
    this.router.navigate(['products']);
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



}
