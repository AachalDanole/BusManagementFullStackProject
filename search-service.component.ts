import { Component } from '@angular/core';
import { BusService } from '../bus.service';
import { Bus } from '../bus';

@Component({
  selector: 'app-search-service',
  templateUrl: './search-service.component.html',
  styleUrls: ['./search-service.component.css']
})
export class SearchServiceComponent {

 source : string = "";

     destination : string ="";
     buses : Bus[]=[];

     constructor(private busService : BusService){}

     getBusDetailsBySrcDest(){
      this.busService. getBusDetailsBySrcDest(this.source,this.destination).subscribe(details =>{
        console.log('Response from service:',details);
         this.buses= details;
      },
          error => {
            console.log(error);
         });
        
     }



}