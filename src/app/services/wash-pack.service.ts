import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baseUrl from './helper';
import baseUrl1 from './helper1';

@Injectable({
  providedIn: 'root'
})
export class WashPackService {

  constructor(private _http:HttpClient) { }
  //This is to get washPack
  public washPacks()
  {
    return this._http.get(`${baseUrl1}/washPack/`)
  }

  // to add WashPack
  public addWashPack(pack:any)
  {
    return this._http.post(`${baseUrl1}/washPack/`,pack)
  }

  //to delete WashPack
  public deleteWashPack(id:any)
  {
   return  this._http.delete(`${baseUrl1}/washPack/${id}`,id);
  }
  //get the single washPAck
  public getWashPack(id:any)
  {
    return this._http.get(`${baseUrl1}/washPack/getwashpack/${id}`);
  }

  public updateWashpack(wash:any){
    return this._http.put(`${baseUrl1}/washPack/update-pack`,wash);
  }
}
