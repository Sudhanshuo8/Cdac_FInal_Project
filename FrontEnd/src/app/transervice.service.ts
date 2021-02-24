import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Member } from './member';
import { Transaction } from './transaction';

@Injectable({
  providedIn: 'root'
})
export class TranserviceService {

  private baseUrl="http://localhost:8080/trans_list";
  private baseUrlGet="http://localhost:8080/trans_get/{id}";
  private baseUrlPut="http://localhost:8080/trans_update";

  constructor(private httpClient: HttpClient) { }

  getTransactionList(): Observable<Member[]>{
    return this.httpClient.get<Member[]>(this.baseUrl);

  }

  getMember(id):Observable<Member>{
    return this.httpClient.get<Member>("http://localhost:8080/trans_get/"+id);
  }

  applyloan(membId: number,transaction: Member): Observable<Object>{
    console.log("In service method");
    const result = this.httpClient.put(`${this.baseUrlPut}/${membId}`,transaction);
    console.log(result);
    return result
  }
}
