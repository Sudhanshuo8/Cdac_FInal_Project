import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AboutusComponent } from './aboutus/aboutus.component';
import { AdminComponent } from './admin/admin.component';
import { AllmembersComponent } from './allmembers/allmembers.component';
import { CreateBachatgatComponent } from './create-bachatgat/create-bachatgat.component';
import { CreateLeaderComponent } from './create-leader/create-leader.component';
import { CreateMemberComponent } from './create-member/create-member.component';
import { FooterComponent } from './footer/footer.component';
import { ForgotPasswordComponent } from './forgot-password/forgot-password.component';
import { HeaderComponent } from './header/header.component';
import { LeaderListComponent } from './leader-list/leader-list.component';
import { LeaderComponent } from './leader/leader.component';
import { LoginComponent } from './login/login.component';
import { MemberListComponent } from './member-list/member-list.component';
import { MemberComponent } from './member/member.component';
import { PagenotfoundComponent } from './pagenotfound/pagenotfound.component';
import { ProductListComponent } from './product-list/product-list.component';
import { ProductComponent } from './product/product.component';
import { TransactHomeComponent } from './transact-home/transact-home.component';
import { TransactListComponent } from './transact-list/transact-list.component';
import { TranssactionAddComponent } from './transsaction-add/transsaction-add.component';

const routes: Routes = [
  {path: "aboutus" , component : AboutusComponent},
  {path: "admin" , component : AdminComponent},
  {path: "leader/gatReg" , component : CreateBachatgatComponent},
  {path: "leaderReg" , component : CreateLeaderComponent},
  {path: "leader/memberReg" , component : CreateMemberComponent},
  {path: "footer" , component : FooterComponent},
  {path: "header" , component : HeaderComponent},
  {path: "leaderList" , component : LeaderListComponent},
  {path: "login" , component : LoginComponent},
  {path: "member" , component : MemberComponent},
  {path: "leader" , component : LeaderComponent},
  {path: "leader/memberList" , component : MemberListComponent},
  {path: "memberList" , component : MemberListComponent},
  {path: "transactionHome" , component : TransactHomeComponent},
  {path: "transactionHome/transactionAdd" , component : TranssactionAddComponent},
  {path: "transactionList" , component : TransactListComponent},
  {path: "allmembers" , component : AllmembersComponent},
  {path: "addProduct" , component : ProductComponent},
  {path: "products" , component : ProductListComponent},
  {path: "forgot" , component : ForgotPasswordComponent},
  
  {path: '', redirectTo:'/login', pathMatch: 'full'},
  {path: '**', component: PagenotfoundComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
