import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baseUrl3 from 'src/app/services/helper3';

@Injectable({
  providedIn: 'root'
})
export class UserOrderService {

  constructor(private _http:HttpClient) { }
  //This is to get all Order
  public getAllOrder()
  {
    return this._http.get(`${baseUrl3}/order/getall`)
  }

  
  // to add New Order
  public addOrder(order:any)
  {
    return this._http.post(`${baseUrl3}/order/addOrder`,order)
  }

}
