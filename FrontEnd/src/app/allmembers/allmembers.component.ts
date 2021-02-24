import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Bachatgat } from '../bachatgat';
import { Member } from '../member';
import { MemberService } from '../member.service';
import { Transaction } from '../transaction';
import { TranserviceService } from '../transervice.service';

@Component({
  selector: 'app-allmembers',
  templateUrl: './allmembers.component.html',
  styleUrls: ['./allmembers.component.css']
})
export class AllmembersComponent implements OnInit {

  gatId = sessionStorage.getItem('gatId');

  members: Member[];
  gats: Bachatgat[];
  transaction: Member[];

  constructor(private httpClient : HttpClient, private membServ: MemberService , private router : Router,private tranService:TranserviceService) { }

  ngOnInit(): void {
    console.log(this.gatId);

    this.getMembers();
   this.getTransaction();
  }



  private getMembers(){
    console.log(this.gatId);
    this.membServ.getCustomerList().subscribe(data => {
      this.members = data;
    });
  }

  private getTransaction(){
    this.tranService.getTransactionList().subscribe(data =>{
      console.log(data)
      this.transaction=data;
    }
    );
  }
}
