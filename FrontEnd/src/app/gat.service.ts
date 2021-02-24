import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Bachatgat } from './bachatgat';

@Injectable({
  providedIn: 'root'
})
export class GatService {

  constructor(private http: HttpClient) { }

  public addGat(gat : Bachatgat): Observable<any>
  {
    return this.http.post<any>("http://localhost:8080/adduser", user)
  }
}
