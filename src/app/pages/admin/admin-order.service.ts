import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baseUrl1 from 'src/app/services/helper1';
import baseUrl2 from 'src/app/services/helper2';

@Injectable({
  providedIn: 'root'
})
export class AdminOrderService {

  constructor(private _http:HttpClient) { }
  public Admin()
  {
     return this._http.get(`${baseUrl1}/washPack/allOrders`);
   }
   //to delete Washer
  public deleteWasher(id:any)
  {
   return  this._http.delete(`${baseUrl2}/washer/${id}`,id);
  }
}
