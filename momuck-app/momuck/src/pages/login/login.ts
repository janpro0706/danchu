import {Component} from '@angular/core';
import {Http, Headers, RequestOptions} from '@angular/http';
import {NavController} from 'ionic-angular';
import 'rxjs/Rx';

@Component({
  selector: 'page-login',
  templateUrl: 'login.html'
})
export class LoginPage {
  account: { email: string, password: string }

  constructor(public navCtrl: NavController, public http: Http) {
    this.account = {
      email: "",
      password: ""
    };
  }

  _doLogin() {
    var headers = new Headers();
    headers.append('Content-Type', 'application/json');
    var options = new RequestOptions({headers: headers});

    // this.http.post('http://dev.momuck.com/momuck/accouts/login', JSON.stringify(this.account), options).subscribe(res => {
    this.http.post('http://localhost:8080/accounts/login', JSON.stringify(this.account), options).subscribe(res => {
      console.dir(res);
      if (res.json().code == 900) {
        alert("success")
      }
    }, (err) => {
      alert("failed");
    });
  }

}
