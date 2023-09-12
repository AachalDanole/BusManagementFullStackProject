import { Component, OnInit } from '@angular/core';
import { Bus } from '../bus';
import { ActivatedRoute, Router } from '@angular/router';
import { BusService} from '../bus.service';
import { User } from '../user';
import { EmailService } from '../email.service';
import { UserService } from '../user.service';


@Component({
  selector: 'app-bus-details',
  templateUrl: './book-bus.component.html',
  styleUrls: [ './book-bus.component.css']
})
export class BookbusComponent implements OnInit {

  busId: number = 0;
  user: User = new User();
  userEmail: String = "";
 
  formatedDate!:string;
  bus:Bus=new Bus();
  constructor(private userService: UserService,private BusService:BusService,private EmailService:EmailService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.busId = this.route.snapshot.params['busId'];
console.log(this.busId);
   
    };
  
  
    goToBusList(){
      this.router.navigate(['/bus']);
    }
  
  
  home(){
    this.router.navigate(['bus']);
  }

  mailchecking(){
    this.bus = new Bus();
    this.BusService.getBusDetailsById(this.busId).subscribe( data => {
      this.bus = data;
      
    });
    this.EmailService.checkEmail(this.user.userEmail, this.bus).subscribe(data => {
      console.log(data);
     
    },
    error => console.log(error));
   
  }

  onSubmit(){
    this.addBooking();
    console.log("add user data to the user table... booking sucesful mail should to gooo");
    console.log(this.user.userEmail);
    if (this.user.userEmail) {
      this.mailchecking();

    } else {
      console.log('userEmail is null, cannot make API request.');
    }
  }

  addBooking() {
    this.userService.addBooking (this.user,this.busId).subscribe(data=>{

     console.log(data);
    },
    error=>console.log(error));
   }



}
