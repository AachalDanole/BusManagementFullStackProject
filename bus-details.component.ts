import { Component, OnInit } from '@angular/core';
import { Bus } from '../bus';
import { ActivatedRoute } from '@angular/router';
import { BusService} from '../bus.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-bus-details',
  templateUrl: './bus-details.component.html',
  styleUrls: ['./bus-details.component.css']
})
export class BusDetailsComponent implements OnInit {

  busId: number = 0;
  bus: any = [];
  constructor(private route: ActivatedRoute,private router:Router, private busService: BusService) { }

  ngOnInit(): void {
    this.busId = this.route.snapshot.params['busId'];

    this.bus = new Bus();
    this.busService.getBusDetailsById(this.busId).subscribe( data => {
      this.bus = data;
    });
  }

  bookbus(busId:number){
    console.log("Helloo");
    this.router.navigate(['book-bus',busId]);

  }

}