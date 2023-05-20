import { Component, OnInit } from '@angular/core';
import { Currency } from 'src/app/models/currency';
import { Product } from 'src/app/models/product';
import { Staff } from 'src/app/models/staff';
import { HttpServerServiceService } from 'src/app/services/http-server-service.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  //declare a variable to store api data
  staffs: Staff[] | null | undefined;
  name: string = "xzcz";
  public getStaffInfoUrl:string = "http://localhost:8080/staff-info";

  // declare constructor used
  constructor(private httpServerService: HttpServerServiceService) { }

  // body
  ngOnInit(): void {
    
    this.httpServerService.getAll(this.getStaffInfoUrl).subscribe((res:any)=>{
        this.staffs = res;
        console.log(this.staffs);
        
    })
  };
  
}
