import { Component, OnInit } from '@angular/core';
import { ManageWasherService } from 'src/app/services/manage-washer.service';
import Swal from 'sweetalert2';
@Component({
  selector: 'app-manage-washer',
  templateUrl: './manage-washer.component.html',
  styleUrls: ['./manage-washer.component.css']
})
export class ManageWasherComponent implements OnInit {
  Washers=[{
    id:"21",
    username:"AyushGhai",
    password:"Ayushghai@123",
    washerName:"Atharv",
    contactNo:9898,
    washerEmail:"ayushghai@123",
    washerAddress:"A-10 Park view Appts Kings Way Nagpur",
    role:""


    }

  ]

  constructor(private _wash:ManageWasherService) { }

  ngOnInit(): void {
    this._wash.washers().subscribe(
      (data:any)=>{
        this.Washers=data;
        console.log(this.Washers)
      },
      (error)=>{
        console.log(error);
        Swal.fire('Error',"Error in loading data");
      }

    )
  }
  //delete Washer
  deleteWasher(id:any){
    Swal.fire({
      icon:'info',
      title:'Are you sure ?',
      confirmButtonText:'Delete',
      showCancelButton:true,
}).then((result)=>{
  if(result.isConfirmed)
  {
    this._wash.deleteWasher(id).subscribe(
      (data)=>{
        this.Washers=this.Washers.filter((wash)=>wash.id!=id);
        Swal.fire('Success','washPack deleted','success');
      },(error)=>{
        Swal.fire('Error','Error in deleting washPack','error');
      }
      );
  }
})
   
  }
  }

