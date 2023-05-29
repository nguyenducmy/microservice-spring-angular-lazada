import { Component } from '@angular/core';

@Component({
  selector: 'app-main-banner',
  templateUrl: './main-banner.component.html',
  styleUrls: ['./main-banner.component.css']
})
export class MainBannerComponent {
  imgCollection: Array<object> = [
    {
      image: 'assets/images/slider6.jpg',
      thumbImage: 'assets/images/slider6.jpg',
      alt: 'Image 1',
    }, {
      image: 'assets/images/slider3.png',
      thumbImage: 'assets/images/slider3.png',

      alt: 'Image 2'
    }, {
      image: 'assets/images/slider3.png',
      thumbImage: 'assets/images/slider3.png',

      alt: 'Image 3'
    }, {
      image: 'assets/images/slider4.jpg',
      thumbImage: 'assets/images/slider4.jpg',

      alt: 'Image 4'
    }, {
      image: 'assets/images/slider3.png',
      thumbImage: 'assets/images/slider3.png',

      alt: 'Image 5'
    }
  ];

}
