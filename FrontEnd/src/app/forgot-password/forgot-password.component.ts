import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormBuilder, Validators } from '@angular/forms';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-forgot-password',
  templateUrl: './forgot-password.component.html',
  styleUrls: ['./forgot-password.component.css']
})
export class ForgotPasswordComponent implements OnInit {

  public uiInvalidCredential = false;

  public fbFormGroup = this.fb.group({
    emailId: ['', Validators.required],
    password: ['', Validators.required],

  });
  constructor(private router: Router,
    private fb: FormBuilder,
    private http: HttpClient) { }

  gotoLogin(page) {
    this.router.navigate(['login']);
  }

  ngOnInit(): void {
  }
  async changepass() {
    const data = this.fbFormGroup.value;
    const url = 'http://localhost:8080/forget_password';

      console.log(data)

      const data1 = JSON.parse(data);
      console.log(data1)
      const result: any = await this.http.post(url, data1).toPromise();

      console.log(result.Parse());
      this.fbFormGroup.reset();
      alert("you have successfully changed your password");
      this.router.navigate[('login')];
  }
}
