import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baseUrl from 'src/app/services/helper';
import baseUrl2 from 'src/app/services/helper2';

@Injectable({
  providedIn: 'root'
})
export class RatingService {

  constructor(private _http:HttpClient) { }

  //This is to get Rating
  public Ratings()
  {
    return this._http.get(`${baseUrl2}/washer/allrating`)
  }

   // to add rating
   public addRating(rate:any)
   {
     return this._http.post(`${baseUrl}/customers/rating`,rate)
   }
}
