import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { BusListComponent } from './bus-list/bus-list.component';
import {CreateBusComponent } from './create-bus/create-bus.component';
import { UpdateBusComponent } from './update-bus/update-bus.component';
import { BusDetailsComponent } from './bus-details/bus-details.component';
import { HomeComponent } from './home/home.component';
import { AboutusComponent } from './aboutus/aboutus.component';
import { ContactusComponent } from './contactus/contactus.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { AuthGaurdServiceService } from './auth-gaurd-service.service';
import { BookbusComponent } from './book-bus/book-bus.component';
import { UserListComponent } from './user-list/user-list.component';
import { FeedbackComponent } from './feedback/feedback.component';
import { SignupComponent } from './signup/signup.component';
import { UserDetailsComponent } from './userdetails/userdetails.component';
import { DriverListComponent } from './driver-list/driver-list.component';
import { CreateDriverComponent } from './create-driver/create-driver.component';
import { DriverDetailsComponent } from './driver-details/driver-details.component';
import { UpdateDriverComponent } from './update-driver/update-driver.component';



const routes: Routes = [
  
  {path: 'bus', component: BusListComponent,canActivate:[AuthGaurdServiceService]},
  {path: 'create-bus', component: CreateBusComponent,canActivate:[AuthGaurdServiceService]},
  //{path: '', redirectTo: 'bus', pathMatch: 'full'},
  {path: 'update-bus/:busId', component: UpdateBusComponent,canActivate:[AuthGaurdServiceService]},
  {path: 'bus-details/:busId', component: BusDetailsComponent,canActivate:[AuthGaurdServiceService]},
  {path: 'home', component: HomeComponent,canActivate:[AuthGaurdServiceService]},
  {path: 'aboutus', component: AboutusComponent,canActivate:[AuthGaurdServiceService]},
  {path: 'contactus', component: ContactusComponent,canActivate:[AuthGaurdServiceService]},
  {path: 'login', component: LoginComponent},
  {path: 'logout', component: LogoutComponent,canActivate:[AuthGaurdServiceService]},
  {path: 'book-bus/:busId',component:BookbusComponent },
  {path:'user-list/:busId',component:UserListComponent},
  {path:'feedback',component:FeedbackComponent},
  {path:'signup',component:SignupComponent},
  {path:'user-details/:userId',component:UserDetailsComponent},
  {path:'driver-list',component:DriverListComponent},
  {path:'create-driver',component:CreateDriverComponent},
  {path:'driver-details/:driverId',component:DriverDetailsComponent},
  {path:'update-driver/:driverId',component:UpdateDriverComponent}
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],                                                                                                                                                                                                                                                                                                          
  exports: [RouterModule]
})
export class AppRoutingModule { }