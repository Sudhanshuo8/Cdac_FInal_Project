import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Leader } from '../leader';
import { LeaderService } from '../leader.service';
import { NgModule } from '@angular/core';
import { BackButtonDisableModule } from 'angular-disable-browser-back-button';
import { PlatformLocation } from '@angular/common'; 

export class AppModule {}



@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {
  leaders : Leader[];

  leader : Leader = new Leader();

  constructor(private http: HttpClient,private leaderServ: LeaderService , private router: Router,location: PlatformLocation) {
    location.onPopState(() => {
      console.log('pressed back in add!!!!!');
      this.router.navigate(['admin']);
      history.forward();
      });
   }

  ngOnInit(): void {
    if (!sessionStorage.getItem('adminSessionId')) {
      this.router.navigate(['login']);
    }
    
    this.getLeader();
  }

  async getLeader()
  {
    this.leaderServ.getLeaderList().subscribe(data => {
      this.leaders = data;
    });
  }

  VerifyLeader(leaderId : number)
  {
    this.leaderServ.updateLeader(leaderId, this.leader).subscribe( data =>{
      console.log(data);
    })

  }



}
