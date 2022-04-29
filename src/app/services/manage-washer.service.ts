import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baseUrl1 from './helper1';
import baseUrl2 from './helper2';

@Injectable({
  providedIn: 'root'
})
export class ManageWasherService {

  constructor(private _http:HttpClient) { }
  public washers()
  {
    return this._http.get(`${baseUrl1}/washPack/allWasher`);
  }
  //to delete Washer
  public deleteWasher(id:any)
  {
   return  this._http.delete(`${baseUrl2}/washer/${id}`,id);
  }
}
