import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CommonService } from '../common.service';
import { Leader } from '../leader';
import { Member } from '../member';
import { User } from '../user';
import { map, tap } from 'rxjs/operators';
import { FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  public images = ['/assets/2.jpg', "/assets/3.jpg", "/assets/4.jpg"];

  leader = new Leader();

  member = new Member();

  user = new User();
  msg = '';

  leadersId = sessionStorage.getItem('leaderSessionId');

  constructor(    private fb: FormBuilder, private router: Router,private http: HttpClient) { }

  public uiInvalidCredential = false;

  public fbFormGroup = this.fb.group({
    userMail: ['', Validators.required],
    //bachatgat: ['', Validators.required],
    password: ['', Validators.required],
  });

  
  ngOnInit(): void {
    console.log(this.leadersId)
    if(this.leadersId)
    {
      console.log(this.leadersId);
    }
  }

  async loginUser()
  {
    const data = this.fbFormGroup.value;
    const leaderurl = 'http://localhost:8080/leader_list';
    const memberurl = 'http://localhost:8080/member_list';
    const memberOnlyurl = 'http://localhost:8080/members';
    console.log(data);

   let result: any = await this.http.get(leaderurl, data).toPromise();
   console.log(result);

   if(data.userMail == "admin" && data.password == "admin123")
   {
    this.router.navigate(['admin']);
    sessionStorage.setItem('adminSessionId', "admin");


   }
   for(let i= 0;i < result.length;i++)
   {
     if(data.userMail != result[i].leaderEmail || data.password != result[i].leaderPassword )
     {
       console.log("Invalid!!");
       console.log(data.userMail+" "+data.password)
       console.log(result[i].leaderEmail+" "+result[i].leaderPassword)
       document.getElementById('cred').innerHTML = " Either you have entered worng credentials or you are not verified yet ";
      }
     else
     {
           if (!result.opr &&  (result[i].role == "leader")) {
            console.log( result[i].leaderflag)
      
      if( result[i].leaderflag == 1)
      {
              if(result[i].gat != null)
      {
        sessionStorage.setItem('gatId', result[i].gat.gatId);
      }
        sessionStorage.setItem('leadId', result[i].leaderId);
        sessionStorage.setItem('leaderSessionId', "leader");
        this.router.navigate(['leader']);

      }
      else{
        document.getElementById('cred').innerHTML = "  ";
        console.log("You are not yet verified");
        document.getElementById('cred').innerHTML = " Either you have entered worng credentials or you are not verified yet ";
      }

     

      break;
    }      
     }   
  }

  let result1: any = await this.http.get(memberurl, data).toPromise();
  let result2: any = await this.http.get(memberOnlyurl, data).toPromise();
  console.log(result1);
  for(let i= 0;i < result1.length;i++)
  {
    if(data.userMail != result2[i].memberEmail || data.password != result2[i].memberDOB )
    {
      console.log("Invalid!!");
      console.log( result1)
      console.log(data.userMail+" "+data.password)
      console.log(result2[i].memberEmail+" "+result2[i].memberDOB)

      document.getElementById('cred').innerHTML = " Either you have entered worng credentials or you are not verified yet ";}
    else
    {

      console.log("in else")
      console.log( result1[0].gat.gatId )
          if (!result2.opr &&  result2[i].role == "member") {
            sessionStorage.setItem('gatId', result1[i].gat.gatId);  
            console.log("gat1");   
            sessionStorage.setItem('gatName', result1[i].gat.bachatgatName);
            sessionStorage.setItem('gatCount', result1[i].gat.memberCount);
     sessionStorage.setItem('memberName', result2[i].memberName);
     sessionStorage.setItem('memberId', result2[i].memberId);
     sessionStorage.setItem('memberSessionId', "member");
     this.router.navigate(['member']);
     break;
   }      
    }   
 }


  /*LoginUser() {

    this.service.loginUserFromRemote(this.leader).subscribe(

      data => {


        sessionStorage.setItem('emailId', this.leader.leaderEmail)


        console.log(this.leader.role);

        if (this.leader.role == "Leader") {

          this._router.navigate(['/leader']
          );
        }
        else if (this.leader.role == "Customer") {
          this._router.navigate(['/member']);
        }
        else
          this._router.navigate(['/login']);
        console.log("resp received");

      },
      error => {
        console.log("Error occured");
        this.msg = "Enter valid credentials for login";
      }
    )
  }*/

}
}
