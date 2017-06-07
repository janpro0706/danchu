import { Component } from '@angular/core';
import { NavController, NavParams, ViewController } from 'ionic-angular';

import { ReviewService } from './review.service';

import 'rxjs/add/operator/toPromise';

@Component({
  selector: 'review-tab',
  templateUrl: './review-tab.html',
  providers: [ ReviewService ]
})
export class ReviewTab {
  reviews = [];

  constructor(private params: NavParams,
              private viewCtrl: ViewController,
              private navCtrl: NavController,
              private reviewService: ReviewService) {
  }

  ionViewDidLoad() {
    // tricks for parent component being able to get the instance of a tab's root component
    this.params.get('getTabPageInst')(this);
    this.getOlderReviews(10);
  }

  getRecentReviews(requestNum) {
    const foodIdx = this.params.get('foodIdx');

    this.reviewService.getFoodReview(foodIdx, 0, requestNum)
      .then(reviews => {
        if (!reviews) {
          return;
        }

        const currentSeq = this.reviews[0].seq;

        const recentReviews = reviews.filter(r => r.seq > currentSeq)
          .map(this.reviewMapper);

        this.reviews = [ ...recentReviews, ...this.reviews ];
      });
  }

  getOlderReviews(requestNum) {
    const foodIdx = this.params.get('foodIdx');

    this.reviewService.getFoodReview(foodIdx, this.reviews.length, requestNum)
      .then(reviews => {
        if (!reviews) {
          return;
        }

        const olderReviews = reviews.map(this.reviewMapper);

        this.reviews = [ ...this.reviews, ...olderReviews ];
      });
  }

  reviewMapper(rawReview) {
    // TODO: get author name using GET /profile
    const { seq, user_seq: author, message, created: date, score: star } = rawReview;

    return { seq, author: '윤지수', message, date: date.replace(/-/g, '.'), star };
  }

  range(range: Number) {
    const arr = [];
    for (let i = 0; i < range; i++) arr.push(i);
    return arr;
  }

  yyyymmdd(date: Date) {
    const year = date.getFullYear();
    const month = date.getMonth() + 1;
    const _date = date.getDate();

    const yyyy = '' + year;
    const mm = month < 10 ? '0' + month : month;
    const dd = _date < 10 ? '0' + _date : _date;

    return `${yyyy}.${mm}.${dd}`;
  }
}
