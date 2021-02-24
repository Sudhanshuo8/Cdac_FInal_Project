import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-create-member',
  templateUrl: './create-member.component.html',
  styleUrls: ['./create-member.component.css']
})
export class CreateMemberComponent implements OnInit {
  gatId = sessionStorage.getItem('gatId');
  public uiInvalidCredential = false;
  public fbFormGroup = this.fb.group({
    memberName: ['', Validators.required ],
    memberDOB: ['', Validators.required],
    memberGender: ['', Validators.required],
    memberEmail: ['', Validators.required],
    memberContactNumber: ['', Validators.required],
  });
  get first(): any {
    return this.fbFormGroup.get('memberName');
  }

  constructor(    private fb: FormBuilder,
    private router: Router,
    private http: HttpClient) { }

  ngOnInit(): void {
    if (!sessionStorage.getItem('leaderSessionId')) {
      this.router.navigate(['login']);
    }
  }

  async addProfileHere() {

    

    //let user1 = sessionStorage.getItem('emailId')
    const data = this.fbFormGroup.value;
    console.log("===========");
    // console.log(user1);
    console.log(data);
    console.log(this.gatId);
    const url = 'http://localhost:8080/add_member/' + this.gatId;
    const result: any = await this.http.post(url, data,{responseType: 'text'}).toPromise();
    console.log(this.gatId);
    console.log(result);

    this.fbFormGroup.reset();
    this.router.navigate(['leader']);
  }

  navigateToMemberReg()
  {
    //this.newgatId = this.gatId;
    //console.log(this.newgatId);
    console.log(this.gatId);
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
