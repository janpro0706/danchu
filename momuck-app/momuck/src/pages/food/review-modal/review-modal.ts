import { Component, ChangeDetectorRef } from '@angular/core';
import { ViewController, NavParams } from 'ionic-angular';
import { ReviewService } from '../review-tab/review.service';

@Component({
  selector: 'review-modal',
  templateUrl: './review-modal.html',
  providers: [ ReviewService ]
})
export class ReviewModal {
  review = { score: 5, message: '' };

  constructor(private viewCtrl: ViewController,
              private detector: ChangeDetectorRef,
              private params: NavParams,
              private reviewService: ReviewService) {

  }

  onDismiss(e) {
    if (e.srcElement.className === 'dimmer') {
      this.viewCtrl.dismiss();
    }
  }

  onCancel(e) {
    this.viewCtrl.dismiss();
  }

  onSubmit(e, review) {
    const foodIdx = this.params.get('foodIdx');
    const { score, message } = this.review;

    this.reviewService.postFoodReview(foodIdx, { score, message })
      .then(rev => {
        this.viewCtrl.dismiss(rev);
      });
  }

  onStarClick(e, idx) {
    this.review.score = idx;
    this.detector.detectChanges();
  }

  onTextChange(e, message) {
    // TODO: check input length or something else
  }

  range(idx) {
    const arr = [];
    for (let i = 0; i < idx; i++) {
      arr.push(i);
    }
    return arr;
  }
}
