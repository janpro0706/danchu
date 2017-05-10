import { Component } from '@angular/core';
import { NavController, NavParams } from 'ionic-angular';

@Component({
  selector: 'review-tab',
  templateUrl: './review-tab.html'
})
export class ReviewTab {
  reviews = [
    {
      author: '윤지수',
      message: `동해물과 백두산이 마르고 닳도록`,
      star: 3,
      date: new Date('2017-01-02')
    },
    {
      author: '이희백',
      message: `개노맛 핵노맛 존나노맛 돈아까운맛!!!!`,
      star: 4,
      date: new Date('2017-01-02')
    },
    {
      author: '최윤정',
      message: `수업언제끝나으으아으아으으아아아
      진짜 너무하네`,
      star: 4,
      date: new Date('2017-01-02')
    },
  ];

  constructor(private params: NavParams) {
    this.reviews = [ ...this.reviews, ...this.reviews, ...this.reviews, ...this.reviews ];

    console.log(this.params.get('restaurantIdx'));
  }

  range(range: Number) {
    const arr = [];
    for (let i = 0; i < range; i++) arr.push(i);
    return arr;
  }
}
