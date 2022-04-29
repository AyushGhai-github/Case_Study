import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baseUrl2 from 'src/app/services/helper2';
import baseUrl3 from 'src/app/services/helper3';

@Injectable({
  providedIn: 'root'
})
export class ViewOrderService {

  constructor(private _http:HttpClient) { }
  public washers()
  {
     return this._http.get(`${baseUrl2}/washer/allOrders`);
   }
}
