import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Member } from './member';

@Injectable({
  providedIn: 'root'
})
export class MemberService {
  gatId = sessionStorage.getItem('gatId');


  constructor(private httpClient: HttpClient) { }

  private baseURL1= "http://localhost:8080/member_list/"+ this.gatId;


  getCustomerList() : Observable<Member[]>{
    return this.httpClient.get<Member[]>(this.baseURL1);
  }


}
