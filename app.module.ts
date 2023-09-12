import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule} from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BusDetailsComponent } from './bus-details/bus-details.component';
import { CreateBusComponent } from './create-bus/create-bus.component';
import { BusListComponent } from './bus-list/bus-list.component';
import { UpdateBusComponent } from './update-bus/update-bus.component';
import { NgxPaginationModule } from 'ngx-pagination';
import { HomeComponent } from './home/home.component';
import { AboutusComponent } from './aboutus/aboutus.component';
import { ContactusComponent } from './contactus/contactus.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { BookbusComponent } from './book-bus/book-bus.component';
import { UserListComponent } from './user-list/user-list.component';
import { FeedbackComponent } from './feedback/feedback.component';
import { SignupComponent } from './signup/signup.component';
import { AdminComponent } from './admin/admin.component';
import { UserDetailsComponent } from './userdetails/userdetails.component';
import { DriverDetailsComponent } from './driver-details/driver-details.component';
import { DriverListComponent } from './driver-list/driver-list.component';
import { CreateDriverComponent } from './create-driver/create-driver.component';
import { UpdateDriverComponent } from './update-driver/update-driver.component';




@NgModule({
  declarations: [
    AppComponent,
    BusDetailsComponent,
    CreateBusComponent,
    BusListComponent,
    UpdateBusComponent,
    HomeComponent,
    AboutusComponent,
    ContactusComponent,
    LoginComponent,
    LogoutComponent,
    BookbusComponent,
    UserListComponent,
    FeedbackComponent,
    SignupComponent,
    AdminComponent,
    UserDetailsComponent,
    DriverDetailsComponent,
    DriverListComponent,
    CreateDriverComponent,
    UpdateDriverComponent,
   
    
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    NgxPaginationModule,
   

    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }