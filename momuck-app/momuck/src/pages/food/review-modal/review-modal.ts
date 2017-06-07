import { Component, ChangeDetectorRef } from '@angular/core';
import { ViewController } from 'ionic-angular';

@Component({
  selector: 'review-modal',
  templateUrl: './review-modal.html'
})
export class ReviewModal {
  review = { score: 5, message: '' };

  constructor(private viewCtrl: ViewController,
              private detector: ChangeDetectorRef) {

  }

  onDismiss(e) {
    if (e.srcElement.className === 'dimmer') {
      this.viewCtrl.dismiss('dismiss');
    }
  }

  onCancel(e) {
    this.viewCtrl.dismiss('cancel');
  }

  onSubmit(e, review) {
    // TODO: before dismiss, post the review and dismiss with data that newly posted review
    this.viewCtrl.dismiss(review);
  }

  onStarClick(e, idx) {
    this.review.score = idx;
    this.detector.detectChanges();
  }

  onTextChange(e, message) {
    // TODO: check input length or something else
    // console.log('on text change');
  }

  range(idx) {
    const arr = [];
    for (let i = 0; i < idx; i++) {
      arr.push(i);
    }
    return arr;
  }
}
