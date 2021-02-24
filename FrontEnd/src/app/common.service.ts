import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { map, tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class CommonService {

  constructor(private http: HttpClient) { }


  public loginUserFromRemote(user: any): Observable<any> {




    var a = this.http.post<any>("http://localhost:8080/login", user).pipe(map(data => {
      sessionStorage.setItem('userId', data.userId);
      sessionStorage.setItem('username', data.userName);

    }
    ));

    console.log(a);
    console.log(user);
    return a;

  }
}
