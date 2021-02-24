import { Component, OnInit } from '@angular/core';
import { Member } from '../member';
import { Transaction } from '../transaction';
import { TranserviceService } from '../transervice.service';

@Component({
  selector: 'app-transact-list',
  templateUrl: './transact-list.component.html',
  styleUrls: ['./transact-list.component.css']
})
export class TransactListComponent implements OnInit {
  transaction: Member[];

  constructor(private tranService:TranserviceService) { }

  ngOnInit(): void {
   this.getTransaction();
  }
  private getTransaction(){
    this.tranService.getTransactionList().subscribe(data =>{
      this.transaction=data;
    }
    );
  }
}
