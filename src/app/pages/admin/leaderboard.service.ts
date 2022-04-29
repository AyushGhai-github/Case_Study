import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baseUrl1 from 'src/app/services/helper1';

@Injectable({
  providedIn: 'root'
})
export class LeaderboardService {

  constructor(private _http:HttpClient) { }
  //This is to get LeaderBoard
  public Leaderboard()
  {
    return this._http.get(`${baseUrl1}/washPack/get-leaderboard`)
  }

  // to add new washer to leaderboard
  public addLeaderBoard(leader:any)
  {
    return this._http.post(`${baseUrl1}/washPack/leaderboard`,leader)
  }

  //getById
  public getWasher(rank:any){
    return this._http.get(`${baseUrl1}/washPack/getrank/${rank}`);
}
  //Update
  public updateLeader(leader:any){
    return this._http.put(`${baseUrl1}/washPack/update-leaderboard`,leader);
  }


}
