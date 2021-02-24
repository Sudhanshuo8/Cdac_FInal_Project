import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { LeaderService } from '../leader.service';

@Component({
  selector: 'app-create-leader',
  templateUrl: './create-leader.component.html',
  styleUrls: ['./create-leader.component.css']
})
export class CreateLeaderComponent implements OnInit {

  msg = '';
  public uiInvalidCredential = false;
  public fbFormGroup = this.fb.group({
    leaderName: ['', Validators.required],
    leaderPassword: ['', Validators.required],
    leaderEmail: ['', Validators.required],
    leaderContactNumber: ['', Validators.required],
  });

  constructor(
    private service : LeaderService,
    private fb: FormBuilder,
    private router: Router,
    private http: HttpClient
  ) { }

  ngOnInit(): void {

  }

  async RegisterProcessHere() {

    const data = this.fbFormGroup.value;

    console.log(data);
    this.service.RegisterUserFromRemote(data).subscribe(

      data => {

        console.log("added");
        this.router.navigate(['/login']);

      },
      error => {
        console.log("Error occured");
        this.msg = "Enter valid credentials for login";
      }
    )
  }

  /*async RegisterProcessHere() {
    const data = this.fbFormGroup.value;
    if (data.password === data.cpassword) {
      const url = 'http://localhost:8080/add_leader';
      const result: any = await this.http.post(url, data).toPromise();
    }
    this.fbFormGroup.reset();
    this.router.navigate(['/login']);
  }*/

}
