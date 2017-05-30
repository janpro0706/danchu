import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { NavController, NavParams } from 'ionic-angular';

import { RestaurantService } from './restaurant.service';
import { ReviewTab } from './review-tab/review-tab';

@Component({
  selector: 'page-food',
  templateUrl: './food.html',
  providers: [ RestaurantService ]
})
export class FoodPage implements OnInit {
  tabs = [ ReviewTab ];
  restaurantInfo = {};
  mainImg = './assets/image/food/main_img.png';

  constructor(private navCtrl: NavController, private params: NavParams, private detector: ChangeDetectorRef, private restaurantService: RestaurantService) {
  }

  ngOnInit() {
    // TODO: fetch review author after get user name implmented
    // TODO: implment post-review process
    const resIdx = this.params.get('restaurantIdx');
    const foodIdx = this.params.get('foodIdx');

    this.restaurantService.getRestaurant(resIdx).then(rest => {
      this.restaurantInfo = rest;
      this.detector.detectChanges();
    });
  }
}
