import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreateLeaderComponent } from './create-leader/create-leader.component';
import { LeaderListComponent } from './leader-list/leader-list.component';
import { CreateMemberComponent } from './create-member/create-member.component';
import { DeleteMemberComponent } from './delete-member/delete-member.component';
import { MemberListComponent } from './member-list/member-list.component';
import { CreateBachatgatComponent } from './create-bachatgat/create-bachatgat.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { LoginComponent } from './login/login.component';
import { AdminComponent } from './admin/admin.component';
import { AboutusComponent } from './aboutus/aboutus.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { MemberComponent } from './member/member.component';
import { LeaderComponent } from './leader/leader.component';
import { LogoutComponent } from './logout/logout.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { TranssactionAddComponent } from './transsaction-add/transsaction-add.component';
import { TransactHomeComponent } from './transact-home/transact-home.component';
import { TransactListComponent } from './transact-list/transact-list.component';
import { AllmembersComponent } from './allmembers/allmembers.component';
import { ProductComponent } from './product/product.component';
import { ProductListComponent } from './product-list/product-list.component';
import { PagenotfoundComponent } from './pagenotfound/pagenotfound.component';
import { BackButtonDisableModule } from 'angular-disable-browser-back-button';
import { ForgotPasswordComponent } from './forgot-password/forgot-password.component';
 


@NgModule({
  declarations: [
    AppComponent,
    CreateLeaderComponent,
    LeaderListComponent,
    CreateMemberComponent,
    DeleteMemberComponent,
    MemberListComponent,
    CreateBachatgatComponent,
    HeaderComponent,
    FooterComponent,
    LoginComponent,
    AdminComponent,
    AboutusComponent,
    MemberComponent,
    LeaderComponent,
    LogoutComponent,
    TranssactionAddComponent,
    TransactHomeComponent,
    TransactListComponent,
    AllmembersComponent,
    ProductComponent,
    ProductListComponent,
    PagenotfoundComponent,
    ForgotPasswordComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
    NgbModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
