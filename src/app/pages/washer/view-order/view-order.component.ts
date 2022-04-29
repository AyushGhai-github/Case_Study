import { Component, OnInit } from '@angular/core';
import { ViewOrderService } from '../view-order.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-view-order',
  templateUrl: './view-order.component.html',
  styleUrls: ['./view-order.component.css']
})
export class ViewOrderComponent implements OnInit {
  Orders=[
    {
      "orderId":1,
        "customerName":"Atharv",
        "customerEmail":"atharvdhirde07@gmail.com",
        "customerAddress":"A-10 Park view Appts KingsWay Nagpur near Kasturchand Park",
        "customerContactNo":"9850744221",
        "carName":"Maruti Ritz",
        "carNo":"Mh-31-009",
        "selectedWashpack":"Premium-Wash",
        "date":"22-04-2022",
        "time":"22:52",
        "totalAmount":20000.0,
        "paymentStatus":"Done"
    }
  ]


  constructor(private _order:ViewOrderService) { }

  ngOnInit(): void {
    this._order.washers().subscribe(
      (data:any)=>{
        this.Orders=data;
        console.log(this.Orders)
      },
      (error)=>{
        console.log(error);
        Swal.fire('Error',"Error in loading data");
      }

    )
  }

  }


