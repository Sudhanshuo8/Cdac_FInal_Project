import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Member } from '../member';
import { Transaction } from '../transaction';
import { TranserviceService } from '../transervice.service';

@Component({
  selector: 'app-transsaction-add',
  templateUrl: './transsaction-add.component.html',
  styleUrls: ['./transsaction-add.component.css']
})
export class TranssactionAddComponent implements OnInit {
  membId = sessionStorage.getItem('memberId');
  transaction: Member = new Member();

memberId;
acc_bal;
loan;


  constructor(private tranService:TranserviceService,private router: Router) { }

  ngOnInit(): void {
    //this.transaction.memberId = this.membId;
    this.acc_bal =101;
    console.log(this.membId);
  }

  updatetransaction(membId : number){
    this.tranService.applyloan(membId , this.transaction).subscribe(data=>{
      console.log(data);
      this.router.navigate(['/home']);
      //document.getElementById('ac_bal').defaultValue  = "default value";
    //this.gotoTransactList();
    })
  }

  onSubmit(membId : number){
    /*this.loan=this.transaction.loan;
    this.acc_bal=this.transaction.acc_bal;
    this.acc_bal=this.acc_bal+this.loan;
    console.log(this.acc_bal);*/
      console.log("transactioN : "+this.transaction + membId);
      this.updatetransaction(membId);
    }

}
