import {Component, OnInit} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {calendar} from "../../../../vendors/moment/moment";
import {Product} from "../../../models/product";
import {DomSanitizer, SafeResourceUrl, SafeUrl} from '@angular/platform-browser';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {
  category: string | undefined;
  image: File | undefined;
  public imageShow: any;
  price: string | undefined;
  products: Product[] | undefined;
  private readonly imageType: string = 'data:image/PNG;base64,';

  constructor(private http: HttpClient, private sanitizer: DomSanitizer) {
  }

  electronicDeviceProductsUrl: string = "http://localhost:8082/api/v1/product/get-products-by-category";


  private product: Product | undefined;


  ngOnInit(): void {
    const categoryRequest = "Electronics Device";
    const httpOptions = {
      headers: new HttpHeaders({'content-type': 'application/json'})
    }
    // @ts-ignore
    this.http.post(this.electronicDeviceProductsUrl, categoryRequest, httpOptions).subscribe((res: Product[]) => {
      console.log(res);
      console.log(res[0].category);
      var arr = [];
      var list = new Array();
      for (var i = 0; i < res.length; i++) {
        this.imageShow = this.sanitizer.bypassSecurityTrustUrl(this.imageType + res[i].image);
        console.log(res[i].image);

        // @ts-ignore
        this.product = new Product(res[i].category, res[i].title, res[i].price, res[i].describe, this.imageShow);
        console.log(this.product);
        list.push(this.product);

        // @ts-ignore
        // this.arr.push(this.product);
      }
      console.log("array list ");
      console.log(list);
      this.products = list;
      // console.log(res[0].image)
      // this.imageShow = this.sanitizer.bypassSecurityTrustUrl(this.imageType + res[0].image);
      // this.products = this.arr;
      // @ts-ignore
      console.log(this.products.at(1).imageId)
    })
  }


}
