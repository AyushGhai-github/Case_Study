import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baseUrl2 from 'src/app/services/helper2';

@Injectable({
  providedIn: 'root'
})
export class ViewLeaderboardService {

  constructor(private _http:HttpClient) { }
  public leaderboard()
  {
     return this._http.get(`${baseUrl2}/washer/getLeaderboard`);
   }
}
