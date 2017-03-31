/*
  TempContainer에서 사용되는 child component (대부분 View child)
*/

import { Component } from '@angular/core';

@Component({
  selector: 'some-component',
  templateUrl: './some.component.html'
})
export default class SomeComponent {
  constructor() {

  }

  public someMethod() {
    console.log('some method');
  }
}
