import { NgModule, Component, ContentChild, AfterContentInit, ViewChild, AfterViewInit } from '@angular/core';
import { NavController } from 'ionic-angular';
import TempService from '../../services/temp.service';
import GlobalComponent from '../../components/GlobalComponent/global.component';
import SomeComponent from './SomeComponent/some.component';

@Component({
  selector: 'temp-container',
  providers: [TempService],
  templateUrl: './temp.container.html'
})
export default class TempContainer implements AfterContentInit, AfterViewInit {
  @ContentChild(GlobalComponent) content: GlobalComponent;
  @ViewChild(SomeComponent) comp: SomeComponent;

  constructor(public navCtrl: NavController, private tempService: TempService) {

  }

  ngAfterContentInit() {
    this.content.globalMethod();
  }

  ngAfterViewInit() {
    this.comp.someMethod();
  }
}
