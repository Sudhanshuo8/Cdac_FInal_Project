import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Leader } from './leader';

@Injectable({
  providedIn: 'root'
})
export class LeaderService {
 
  constructor(private http: HttpClient) { }

  public RegisterUserFromRemote(leader: Leader): Observable<any> {

    return this.http.post<any>("http://localhost:8080/add_leader", leader)
  }

  private baseUrl = "http://localhost:8080/leader_list";


  public getLeaderList() : Observable<Leader[]>
  {
    var a = this.http.get<Leader[]>(`${this.baseUrl}`);
    return a;

  }

  private putUrl = "http://localhost:8080/update_leader/";
  public updateLeader(leadId: number , leader : Leader) : Observable<Object>
  {
    return this.http.put(`${this.putUrl}/${leadId}`,leader);
  }
}
