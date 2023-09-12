//import { Component } from '@angular/core';
import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { User } from '../user';
import { ActivatedRoute, Router } from '@angular/router';
import { BusService } from '../bus.service';
import { UserService } from '../user.service';


@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})

export class UserListComponent implements OnInit {
  user: any=[];
  pageNo: number = 1;
  count: number = 5;
  busId:number=0;
  

  constructor(private  userService: UserService ,
    private route: ActivatedRoute,
    private router: Router,
    private cdRef:ChangeDetectorRef) { }

  ngOnInit(): void {
    this.busId = this.route.snapshot.params['busId'];
    this.user=new User();
  this.userService.getUsersByBusId(this.busId).subscribe(data=>{
    console.log(data);
    this.user=data;

  
    });
  }

}