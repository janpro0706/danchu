import { Component, OnInit } from '@angular/core';
import { NavController, NavParams } from 'ionic-angular';

import { ReviewService } from './review.service';

@Component({
  selector: 'review-tab',
  templateUrl: './review-tab.html',
  providers: [ ReviewService ]
})
export class ReviewTab implements OnInit {
  reviews = [];

  constructor(private params: NavParams, private reviewService: ReviewService) {
  }

  ngOnInit() {
    const resIdx = this.params.get('restaurantIdx');
    const foodIdx = this.params.get('foodIdx')

    this.reviewService.getFoodReview(foodIdx, 0, 10)
      .then(reviews => {
        this.reviews = reviews.map(review => {
          // TODO: get author name using GET /profile
          const { user_seq: author, message, created: date, score: star } = review;

          return { author: '윤지수', message, date: date.replace(/-/g, '.'), star };
        });
      });
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
