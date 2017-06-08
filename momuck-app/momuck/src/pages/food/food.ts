import { Component, OnInit, ChangeDetectorRef, ViewChild } from '@angular/core';
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
  tabs: any = {
    review: {
      root: ReviewTab,
    },
  };
  restaurantInfo = {};
  restaurantIdx;
  foodIdx;
  mainImg = './assets/image/food/main_img.png';

  constructor(private navCtrl: NavController,
              private modalCtrl: ModalController,
              private params: NavParams,
              private detector: ChangeDetectorRef,
              private restaurantService: RestaurantService) {
  }

  ngOnInit() {
    this.restaurantIdx = this.params.get('restaurantIdx');
    this.foodIdx = this.params.get('foodIdx');

    for (let name in this.tabs) {
      this.tabs[name].params = { ...this.params.data, getTabPageInst: this.getTabPageInst(name) };
    }

    this.detector.detectChanges();

    this.restaurantService.getRestaurant(this.restaurantIdx).then(rest => {
      this.restaurantInfo = rest || {};
      this.detector.detectChanges();
    });
  }

  onChoose(e) {
    const { restaurantIdx, foodIdx } = this;

    // Tried to customize modal transition, but It meets some problems
    // let modal = this.modalCtrl.create(ReviewModal, null, { enterAnimation: 'alertEnter', leaveAnimation: 'alertLeave' });
    let modal = this.modalCtrl.create(ReviewModal, { restaurantIdx, foodIdx });

    modal.onDidDismiss(review => {
      // TODO: after submit a review in modal, review-tab must update the review
      if (review) {
        const reviewTab = this.tabs.review.inst;
        reviewTab.getRecentReviews(10);
      }
    });
    modal.present();
  }

  getTabPageInst(pageName) {
    return (tabPage) => {
      this.tabs[pageName].inst = tabPage;
    };
  }
}
