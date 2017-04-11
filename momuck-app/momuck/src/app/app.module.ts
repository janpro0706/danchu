import { NgModule, ErrorHandler } from '@angular/core';
import { HttpModule } from '@angular/http';
import { IonicApp, IonicModule, IonicErrorHandler } from 'ionic-angular';
import { IonicStorageModule } from '@ionic/storage';
import { BrowserModule } from '@angular/platform-browser';
import { MyApp } from './app.component';

import { StatusBar } from '@ionic-native/status-bar';
import { SplashScreen } from '@ionic-native/splash-screen';
import { Keyboard } from '@ionic-native/keyboard';

import { declarations, entryComponents } from '../pages/moduleVariables';
import { TestEntry } from './test-entry/test-entry';

@NgModule({
  declarations: [ MyApp, TestEntry ].concat(declarations),
  imports: [
    BrowserModule,
    IonicModule.forRoot(MyApp,{
      scrollAssist: false,
      autoFocusAssist: false
    }),
    HttpModule,
    IonicStorageModule.forRoot()
  ],
  bootstrap: [IonicApp],
  entryComponents: [ MyApp, TestEntry ].concat(entryComponents),
  providers: [
    StatusBar,
    SplashScreen,
    Keyboard,
    {provide: ErrorHandler, useClass: IonicErrorHandler}
  ]
})
export class AppModule {}
