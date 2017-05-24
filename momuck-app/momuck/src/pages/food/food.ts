import { Component } from '@angular/core';
import { NavController, NavParams } from 'ionic-angular';

import { ReviewTab } from './review-tab/review-tab';

@Component({
  selector: 'page-food',
  templateUrl: './food.html'
})
export class FoodPage {
  tabs = [ ReviewTab ];

  constructor(private navCtrl: NavController, private params: NavParams) {
  }
}
