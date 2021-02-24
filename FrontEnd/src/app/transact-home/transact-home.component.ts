import { Component, OnInit } from '@angular/core';
import { Member } from '../member';
import { Transaction } from '../transaction';
import { TranserviceService } from '../transervice.service';

@Component({
  selector: 'app-transact-home',
  templateUrl: './transact-home.component.html',
  styleUrls: ['./transact-home.component.css']
})
export class TransactHomeComponent implements OnInit {
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
  constructor(private tranService:TranserviceService) { }


  ngOnInit(): void {
   this.getTransaction();
   this.getMember();
  }
  private getTransaction(){
    this.tranService.getTransactionList().subscribe(data =>{
      this.transaction=data;
      console.log(this.transaction)
      for(let i=0;i<this.transaction.length;i++){
        this.group_bal=this.group_bal+this.transaction[i].acc_bal;
        console.log("length: "+this.transaction.length+" i = "+i);
        console.log("balance in for loop  "+this.group_bal);
        console.log("total loan in for loop  "+this.total_loan);
        console.log("total loan in for loop  "+this.transaction[i].loan);
        this.total_loan=this.total_loan+this.transaction[i].loan;
       // this.acc_bal = this.acc_bal+this.transaction[i].acc_bal;
        console.log(this.total_loan+" acc balance: "+this.transaction[i].acc_bal + "  "+this.acc_bal)


      }
      this.group_bal=this.group_bal-this.total_loan;
      console.log(this.group_bal);
      console.log(this.loan);
      console.log(this.acc_bal);
    }
    );

  }

  private getMember(){
    this.tranService.getMember(this.memberId).subscribe(data=>{
      console.log(data)
      this.mem_id=data.memberId;
      this.acc_bal=data.acc_bal;
      this.loan=data.loan;
    })
  }
}
