import {Component, OnInit} from '@angular/core';
import {ArrayType} from "@angular/compiler";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Authen} from "../../../models/authen";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  searchText: string |undefined;
  searchReference : string[] | undefined;
  constructor(private http : HttpClient) { }

  searchUrl = "http://localhost:8082/api/v1/product/search-by-product-title";

  ngOnInit(): void {
  }
  onSubmit(){
    const httpOptions = {
      headers: new HttpHeaders({ 'Content-Type': 'application/json' })
    }
    console.log(this.searchText)
    // @ts-ignore
    this.http.post(this.searchUrl, this.searchText, httpOptions).subscribe((res:string[])=>{
      console.log(res);
      this.searchReference = res;
    });
  }

}
