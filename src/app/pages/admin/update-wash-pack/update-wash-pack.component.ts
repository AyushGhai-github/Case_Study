import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { WashPackService } from 'src/app/services/wash-pack.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-update-wash-pack',
  templateUrl: './update-wash-pack.component.html',
  styleUrls: ['./update-wash-pack.component.css']
})
export class UpdateWashPackComponent implements OnInit {

  constructor(private _route:ActivatedRoute,private _wash:WashPackService) { }
  id= 0;
  wash:any;

  ngOnInit(): void {
   this.id = this._route.snapshot.params['wid'];
   alert(this.id);
   this._wash.getWashPack(this.id).subscribe(
     (data:any)=>{
       
       this.wash=data;
       console.log(this.wash);
     },
     (error)=>{
       console.log(error);
     }
   )

  }
  //Update form Submit 
  public updateData(){
   //validate 
   this._wash.updateWashpack(this.wash).subscribe(
     (data)=>{
       Swal.fire("Success !!","WashPack Updated",'success');
     },(error)=>
     {
       Swal.fire('Error','Error in updating WashPAck','error');
       console.log(error);
     })

  }

}
