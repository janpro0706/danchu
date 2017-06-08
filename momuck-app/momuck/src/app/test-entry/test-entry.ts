import { Component } from '@angular/core';
import { NavController } from 'ionic-angular';
import { LoginPage, FoodPage } from '../../pages';

@Component({
  selector: 'test-entry',
  templateUrl: './test-entry.html'
})
export class TestEntry {
  pages = [ LoginPage, FoodPage ]
  pageNavs = []

  constructor(public navCtrl: NavController) {
    this.pageNavs = this.pages.map((page) => {
      return {
        name: page.name,
        component: page,
        goPage: (() => {
          return (e) => {
            const navParam = page == FoodPage ? {
              restaurantIdx: 1,
              foodIdx: 7
            } : null;

            navCtrl.push(page, navParam);
          };
        })()
      };
    });
  }
}
