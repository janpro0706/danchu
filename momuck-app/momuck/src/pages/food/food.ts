import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { NavController, ModalController, NavParams } from 'ionic-angular';

import { RestaurantService } from './restaurant.service';
import { ReviewTab } from './review-tab/review-tab';
import { ReviewModal } from './review-modal/review-modal';

@Component({
  selector: 'page-food',
  templateUrl: './food.html',
  providers: [ RestaurantService ]
})
export class FoodPage implements OnInit {
  tabs = [ ReviewTab ];
  restaurantInfo = {};
  mainImg = './assets/image/food/main_img.png';

  constructor(private navCtrl: NavController,
              private modalCtrl: ModalController,
              private params: NavParams,
              private detector: ChangeDetectorRef,
              private restaurantService: RestaurantService) {
  }

  ngOnInit() {
    // TODO: fetch review author after get user name implmented
    // TODO: implment post-review process
    const resIdx = this.params.get('restaurantIdx');
    const foodIdx = this.params.get('foodIdx');

    this.restaurantService.getRestaurant(resIdx).then(rest => {
      this.restaurantInfo = rest || {};
      this.detector.detectChanges();
    });
  }

  onChoose(e) {
    // Tried to customize modal transition, but It meets some problems
    // let modal = this.modalCtrl.create(ReviewModal, null, { enterAnimation: 'alertEnter', leaveAnimation: 'alertLeave' });
    let modal = this.modalCtrl.create(ReviewModal);

    modal.onDidDismiss(data => {
      // TODO: after submit a review in modal, review-tab must update the review
    });
    modal.present();
  }
}
