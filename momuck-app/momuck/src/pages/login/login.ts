import {Component} from '@angular/core';
import {Http, Headers, RequestOptions} from '@angular/http';
import {Storage} from '@ionic/storage';
import {Keyboard} from '@ionic-native/keyboard';
import {NavController, LoadingController} from 'ionic-angular';
import 'rxjs/Rx';

@Component({
  selector: 'page-login',
  templateUrl: 'login.html'
})
export class LoginPage {
  account: { email: string, password: string }

  constructor(public navCtrl: NavController, public http: Http, public storage: Storage, public loadingCtrl: LoadingController, private keyboard: Keyboard) {
    this.account = {
      email: "",
      password: ""
    };
    keyboard.disableScroll(true);
  }

  private _doLogin() {
    /**
     * @TODO http request와 동기처리가 필요하다. 못하겠음 일단 보류
     * @type {Loading}
     */
    let loading = this.loadingCtrl.create({
      content: "login..",
      duration: 10000,
      dismissOnPageChange: true
    });
    loading.present();

    /**
     * @TODO 사전에 세팅할 수 있는 방법이 있을 것 같다.
     * @type {Headers}
     */
    var headers = new Headers();
    headers.append('Content-Type', 'application/json');
    var options = new RequestOptions({headers: headers});

    this.http.post('http://dev.momuck.com/momuck/accounts/login', JSON.stringify(this.account), options).subscribe(res => {
      if (res.json().code === '900') {
        /**
         * @TODO accessToken localStorage 저장
         */
        this.storage.ready().then(() => {
          this.storage.set("accessToken", "tempToken");
          /**
           *  @TODO 다음페이지로 이동
           */
          this.storage.get('accessToken').then((val) => {
            alert(val); //Test code
          })
        });
      } else {
        alert(res.json().message);
      }
    }, (err) => {
      alert("서버장애 : 관리자에게 문의하세요");
    });
  }
}
