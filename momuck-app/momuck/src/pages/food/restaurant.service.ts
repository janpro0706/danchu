import { Injectable } from '@angular/core';
import { Http, Headers } from '@angular/http';

import 'rxjs/add/operator/toPromise';

const HOST = 'http://dev.momuck.com/momuck';
const RESTAURANT_URL = HOST + '/restaurants';

@Injectable()
export class RestaurantService {
  constructor(private http: Http) {
  }

  getRestaurant(idx: Number): Promise<any> {
    const header = new Headers({ 'Content-Type': 'application/json' });

    return this.http.get(`${RESTAURANT_URL}/${idx}`, { headers: header })
      .toPromise()
      .then(res => {
        const json = res.json();
        return json ? json.data : json;
      })
      .catch(e => console.error(e));
  }
}
