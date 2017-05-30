import { Injectable } from '@angular/core';
import { Http, Headers } from '@angular/http';

import 'rxjs/add/operator/toPromise';

const HOST = 'http://dev.momuck.com/momuck';
const FOOD_URL = HOST + '/foods';

@Injectable()
export class ReviewService {
  constructor(private http: Http) {
  }

  getFoodReview(foodIdx, offset, limit) {
    const header = new Headers({ 'Content-Type': 'application/json' });

    return this.http.get(`${FOOD_URL}/${foodIdx}/reviews?offset=${offset}&limit=${limit}`, { headers: header })
      .toPromise()
      .then(res => {
        const json = res.json();
        return json ? json.data : json;
      })
      .catch(e => console.error(e));
  }

  postFoodReview(foodIdx, score, message) {
    const header = new Headers({ 'Content-Type': 'application/json' });

    return this.http.post(`${FOOD_URL}/${foodIdx}/reviews`, JSON.stringify({ score, message }), { headers: header })
      .toPromise()
      .then(() => ({ score, message }))
      .catch(e => console.error(e));
  }
}
