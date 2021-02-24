import { PlatformLocation } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Bachatgat } from '../bachatgat';
import { Member } from '../member';
import { MemberService } from '../member.service';
export interface RouteInfo {
  path: string;
  title: string;
  icon: string;
  class: string;
}

export const ROUTES: RouteInfo[] = [
  
  { path: '/memberdashboard',   title: 'Member Dashboard',   icon:'nc-bank',       class: '' },
 
];

@Component({
  //moduleId: module.id,
  selector: 'app-member',
  templateUrl: './member.component.html',
  styleUrls: ['./member.component.css']
})
export class MemberComponent implements OnInit {
  gatId = sessionStorage.getItem('gatId');

  memberName = sessionStorage.getItem('memberName');
  memberId = sessionStorage.getItem('memberId');
  bachatgatName = sessionStorage.getItem('gatName');
  memberCount = sessionStorage.getItem('gatCount');

  constructor(private membServ: MemberService , private router : Router,location: PlatformLocation) { 
    location.onPopState(() => {
      console.log('pressed back in add!!!!!');
      this.router.navigate(['leader']);
      history.forward();
      });
  }

  ngOnInit(): void {
    if (!sessionStorage.getItem('memberSessionId')) {
      this.router.navigate(['login']);
      console.log(this.gatId);
    }
  }

  }


