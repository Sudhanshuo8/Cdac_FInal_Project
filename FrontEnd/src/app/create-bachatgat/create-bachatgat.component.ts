import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';


@Component({
  selector: 'app-create-bachatgat',
  templateUrl: './create-bachatgat.component.html',
  styleUrls: ['./create-bachatgat.component.css']
})
export class CreateBachatgatComponent implements OnInit {

  leadId = sessionStorage.getItem('leadId');
  gatId = sessionStorage.getItem('gatId');
  public uiInvalidCredential = false;
  public fbFormGroup = this.fb.group({
    bachatgatName: ['', Validators.required],
    memberCount: ['', Validators.required],
  });

  constructor(    private fb: FormBuilder,
    private router: Router,
    private http: HttpClient) { }

  ngOnInit(): void {
    if (!sessionStorage.getItem('leaderSessionId')) {
      this.router.navigate(['login']);
    }
    console.log(this.gatId);
  }

  async AddGat() {

    //let user1 = sessionStorage.getItem('emailId')
    const data = this.fbFormGroup.value;
    console.log("===========");
    // console.log(user1);
    console.log(data);
    if(this.gatId)
    {
      console.log("already");
      document.getElementById('cred').innerHTML = " You hvae already created one Gat!!";
    }
    const url = 'http://localhost:8080/add_gat/' + this.leadId;
    console.log(data.gatId);
    let result: any = await this.http.post(url, data,{responseType: 'text'}).toPromise();
    console.log(this.leadId);
    console.log(result.JSON.parse());
    sessionStorage.setItem('gatId', data.gatId);

    this.fbFormGroup.reset();
    this.router.navigate(['leader']);
  }

  navigateToMemberReg()
  {
    //this.newgatId = this.gatId;
    //console.log(this.newgatId);
    //console.log(this.gatId);
    this.router.navigate(['leader/memberReg']);
  }

  navigateToGatReg()
  {
    //this.newgatId = this.gatId;
    //console.log(this.newgatId);
    //console.log(this.gatId);
    this.router.navigate(['leader/gatReg']);
  }

  navigateToMemberList(){
    this.router.navigate(['leader/memberList']);

  }

  navigateToAddProduct()
  {
    this.router.navigate(['addProduct']);

  }

  navigateToProductList()
  {
    this.router.navigate(['products']);
  }

  
  
}
