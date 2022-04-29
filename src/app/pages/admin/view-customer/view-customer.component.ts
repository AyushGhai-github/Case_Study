import { Component, OnInit } from '@angular/core';
import { ViewCustomerService } from '../view-customer.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-view-customer',
  templateUrl: './view-customer.component.html',
  styleUrls: ['./view-customer.component.css']
})
export class ViewCustomerComponent implements OnInit {
  
  Customers=[
    {
      customerId:"07",
      userName:"AyushGhai",
      password:"Ayushghai@123",
      customerEmail:"Atharv",
      customerName:9898,
      customerAddress:"A-10 Park view Appts Kings Way Nagpur",
      customerContactNo:"ayushghai@123",
      enabled:"true",
      profile:"Active",
      role:"Customer"
      

    }
  ]

  constructor(private _cust:ViewCustomerService) { }


  ngOnInit(): void {
    this._cust.customers().subscribe(
      (data:any)=>{
        this.Customers=data;
        console.log(this.Customers)
      },
      (error)=>{
        console.log(error);
        Swal.fire('Error',"Error in loading data");
      }

    )
  }
  }

