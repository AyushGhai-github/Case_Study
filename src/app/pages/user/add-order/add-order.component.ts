import { Component, OnInit ,HostListener} from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { UserOrderService } from '../user-order.service';
import Swal from 'sweetalert2';
import { ActivatedRoute } from '@angular/router';
import { WashPackService } from 'src/app/services/wash-pack.service';

declare var Razorpay: any;

@Component({
  selector: 'app-add-order',
  templateUrl: './add-order.component.html',
  styleUrls: ['./add-order.component.css']
})
export class AddOrderComponent implements OnInit {

  constructor(private _snack:MatSnackBar,private _add:UserOrderService,private _route:ActivatedRoute,private _wash:WashPackService) { }
  id= 0;
  wash:any;
  

  Orders=
    {
      "orderId":"",
        "customerName":"",
        "customerEmail":"",
        "customerAddress":"",
        "customerContactNo":"",
        "carName":"",
        "carNo":"",
        "selectedWashpack":"",
        "date":"",
        "time":"",
        "totalAmount":"",
        "paymentStatus":""
    }
  

  ngOnInit(): void {
    this.id = this._route.snapshot.params['wid'];
    //  alert(this.id);
     this._wash.getWashPack(this.id).subscribe(
       (data:any)=>{
         
         this.wash=data;
         console.log(this.wash);
         this.Orders.selectedWashpack = this.wash.packName;
        this. Orders.totalAmount= this.wash.amount;
       },
       (error)=>{
         console.log(error);
       }
     )

  }






  //////
  addOrder()
  {
    if(this.Orders.customerName.trim()=='' || this.Orders.customerName==null)
    {
      this._snack.open("customer name Required","",{
        duration:3000,

      });
      return;
    }
    if(this.Orders.customerEmail.trim()=='' || this.Orders.customerEmail==null)
    {
      this._snack.open("email address is required","",{
        duration:3000,

      });
      return;
    }
    if(this.Orders.customerAddress.trim()=='' || this.Orders.customerAddress==null)
    {
      this._snack.open("address is required","",{
        duration:3000,

      });
      return;
    }
    // if(this.Orders.customerContactNo.trim()=='' || this.Orders.customerContactNo==null)
    // {
    //   this._snack.open("Contact no  is required","",{
    //     duration:3000,

    //   });
    //   return;
    // }
    if(this.Orders.date.trim()=='' || this.Orders.date==null)
    {
      this._snack.open("date  is required","",{
        duration:3000,

      });
      return;
    }
   
   


    //to add data from server
    this._add.addOrder(this.Orders).subscribe(
      (data)=>{
        Swal.fire('Success','Order is Added','success');
        this. Orders=
        {
          "orderId":"",
        "customerName":"",
        "customerEmail":"",
        "customerAddress":"",
        "customerContactNo":"",
        "carName":"",
        "carNo":"",
        "selectedWashpack":"",
        "date":"",
        "time":"",
        "totalAmount":"",
        "paymentStatus":""
        }

      },
    (error)=>{
      Swal.fire("Error!!",'Error while adding Order','error')
      console.log(error)
    })
  };

  // sum(){
  //   this.totalAmount = +this.addOnPrice - +this.promoPrice + +this.carDetailsPrice ;
  // }



  //pay now
  
  message:any = "Not yet stared";
  paymentId = "";
  error = "";
  title = 'angular-razorpay-intergration';
  options = {
    "key": "rzp_test_B2CoXp1wUzwdHB",
    "amount": "20000",
    "name": "Ayush Ghai",
    "description": "Web Development",
    "image": "/assets/default_image.png",
    "order_id": "",
    "handler": function (response: any) {
      var event = new CustomEvent("payment.success",
        {
          detail: response,
          bubbles: true,
          cancelable: true
        }
      );
      window.dispatchEvent(event);
    },
    "prefill": {
      "name": "",
      "email": "",
      "contact": ""
    },
    "notes": {
      "address": ""
    },
    "theme": {
      "color": "#3399cc"
    }
  };

  paynow() {
    this.paymentId = '';
    this.error = '';
    this.options.amount = "200000"; //paise
    this.options.prefill.name = "Ayush";
    this.options.prefill.email = "ayushghai65@gmail.com";
    this.options.prefill.contact = "9850744221";
    var rzp1 = new Razorpay(this.options);
    rzp1.open();
    rzp1.on('payment.failed', function (response: any) {
      //this.message = "Payment Failed";
      // Todo - store this information in the server
      console.log(response.error.code);
      console.log(response.error.description);
      console.log(response.error.source);
      console.log(response.error.step);
      console.log(response.error.reason);
      console.log(response.error.metadata.order_id);
      console.log(response.error.metadata.payment_id);
      //this.error = response.error.reason;
    }
    );
  }
  @HostListener('window:payment.success', ['$event'])
  onPaymentSuccess(event: any): void {
    this.message = "Success Payment";
  }

}


