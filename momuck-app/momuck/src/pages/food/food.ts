import { Component } from '@angular/core';
import { NavController, NavParams } from 'ionic-angular';

import { ReviewTab } from './review-tab/review-tab';

@Component({
  selector: 'page-food',
  templateUrl: './food.html'
})
export class FoodPage {
  tabs = [ ReviewTab ];

  constructor(private navCrl: NavController, private params: NavParams) {
    console.log(this.params.get('restaurantIdx'));
  }
}
