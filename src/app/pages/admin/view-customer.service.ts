import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baseUrl from 'src/app/services/helper';
import baseUrl1 from 'src/app/services/helper1';

@Injectable({
  providedIn: 'root'
})
export class ViewCustomerService {

  constructor(private _http:HttpClient) { }
  public customers()
  {
     return this._http.get(`${baseUrl1}/washPack/allCustomer`);
   }
}
