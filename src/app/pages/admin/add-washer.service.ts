import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baseUrl2 from 'src/app/services/helper2';

@Injectable({
  providedIn: 'root'
})
export class AddWasherService {

  constructor(private _http:HttpClient) { }
  // to add Washer
  public addWasher(washer:any)
  {
    return this._http.post(`http://localhost:8704/washer/`,washer)
  }
  //to delete Washer
  public deleteWasher(id:any)
  {
   return  this._http.delete(`${baseUrl2}/washer/${id}`,id);
  }
}
