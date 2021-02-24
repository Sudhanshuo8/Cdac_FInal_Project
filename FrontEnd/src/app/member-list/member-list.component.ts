import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Bachatgat } from '../bachatgat';
import { Member } from '../member';
import { MemberService } from '../member.service';
import { TransactHomeComponent } from '../transact-home/transact-home.component';
import { Transaction } from '../transaction';
import { TranserviceService } from '../transervice.service';

@Component({
  selector: 'app-member-list',
  templateUrl: './member-list.component.html',
  styleUrls: ['./member-list.component.css']
})
export class MemberListComponent implements OnInit {

  gatId = sessionStorage.getItem('gatId');
  memberName = sessionStorage.getItem('memberName');
  memberId = sessionStorage.getItem('memberId');
  bachatgatName = sessionStorage.getItem('gatName');
  memberCount = sessionStorage.getItem('gatCount');
  transaction: Member[];
  members : Member[];
  mem_id;
  acc_bal ;
  loan ;;
  total_loan=0;
  group_bal=0;

  members: Member[];
  gats: Bachatgat[];
  transaction: Member[];

  constructor(private httpClient : HttpClient, private membServ: MemberService , private router : Router,private tranService:TranserviceService) { }

  ngOnInit(): void {
    console.log(this.gatId);

    this.getMembers();
   this.getTransaction();
   this.getTransactions();
  }



  private getMembers(){
    console.log("in function "+this.gatId);
    this.membServ.getCustomerList().subscribe(data => {
      this.members = data;
    });
  }

  private getTransaction(){
    this.tranService.getTransactionList().subscribe(data =>{
      this.transaction=data;
    }
    );
  }

  private getTransactions(){
    this.tranService.getTransactionList().subscribe(data =>{
      this.transaction=data;
      for(let i=0;i<this.transaction.length;i++){
        this.group_bal=this.group_bal+this.transaction[i].acc_bal;
        console.log("length: "+this.transaction.length+" i = "+i);
        console.log("balance in for loop  "+this.group_bal);
        console.log("total loan in for loop  "+this.total_loan);
        console.log("total loan in for loop  "+this.transaction[i].loan);
        this.total_loan=this.total_loan+this.transaction[i].loan;


      }
      this.group_bal=this.group_bal-this.total_loan;
      console.log(this.group_bal);
      console.log(this.loan);
      console.log(this.acc_bal);
    }
    );

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
