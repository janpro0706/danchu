/*
  여러 Container에서 사용하는 component (주로 Content child)
*/

import { Component } from '@angular/core';

@Component({
  selector: 'global-component',
  templateUrl: './global.component.html'
})
export default class GlobalComponent {
  constructor() {

  }

  public globalMethod() {
    console.log('global method');
  }
}
