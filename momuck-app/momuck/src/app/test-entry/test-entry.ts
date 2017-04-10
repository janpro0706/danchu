import { Component } from '@angular/core';
import { NavController } from 'ionic-angular';
import { LoginPage } from '../../pages';

@Component({
  selector: 'test-entry',
  templateUrl: './test-entry.html'
})
export class TestEntry {
  pages = [ LoginPage ]
  pageNavs = []
  // food: any = FoodPage;

  constructor(public navCtrl: NavController) {
    this.pageNavs = this.pages.map((page) => {
      return {
        name: page.name,
        component: page,
        goPage: (() => {
          return (e) => {
            navCtrl.push(page);
          };
        })()
      };
    });
  }
}
