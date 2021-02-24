import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  logOut()
  {
        sessionStorage.removeItem('gatId');
        sessionStorage.removeItem('memberName', );
        sessionStorage.removeItem('memberId', );
        sessionStorage.removeItem('gatName');
        sessionStorage.removeItem('gatCount');
        sessionStorage.removeItem('leadId');
        sessionStorage.removeItem('leaderSessionId');
        sessionStorage.removeItem('memberSessionId');
        sessionStorage.removeItem('leaderSessionId');
        sessionStorage.removeItem('adminSessionId');
    this.router.navigate(['login']);
  }

}
