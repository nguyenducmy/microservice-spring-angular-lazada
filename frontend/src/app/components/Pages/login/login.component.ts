import {Component, OnInit} from '@angular/core';
import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {HttpServerServiceService} from "../../../services/http-server-service.service";
import {Authen} from 'src/app/models/authen';
import {Staff} from "../../../models/staff";
import {AuthenResponse} from "../../../models/authen-response";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  public username: string | undefined;
  public password: string | undefined;
  public response: string | null | undefined;
  authenResponse: AuthenResponse | null | undefined;
  public authenticateUrl: string = "http://localhost:8088/api/v1/authen/login";

  constructor(private http: HttpClient) {
  }


  ngOnInit(): void {
  }

  public onSubmit() {
    const authen: Authen = new Authen(this.username, this.password);
    // @ts-ignore
    this.http.post(this.authenticateUrl, authen).subscribe((res: AuthenResponse) => {
      console.log(res);
      this.authenResponse = new AuthenResponse(res);
      console.log("object mapping result is - " + this.authenResponse.getJwtToken);
    });
  }
}
