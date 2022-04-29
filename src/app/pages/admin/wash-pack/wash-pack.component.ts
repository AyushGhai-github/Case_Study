import { Component, OnInit } from '@angular/core';
import { WashPackService } from 'src/app/services/wash-pack.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-wash-pack',
  templateUrl: './wash-pack.component.html',
  styleUrls: ['./wash-pack.component.css']
})
export class WashPackComponent implements OnInit {
  washPacks=[
    {
      id:"",
      "packName":"",
      "amount":"",
     
      "discription":'Foam wash shampoos get its name from its physical properties. These vehicle wash shampoo leave a thick white layer on the vehicles exterior surface that is similar in appearance to that of snow hence it is also called snow foam shampoos'
    }
  ];

  constructor(private _wash:WashPackService) { }

  ngOnInit(): void {
    this._wash.washPacks().subscribe(
      (data:any)=>{
        this.washPacks=data;
        console.log(this.washPacks)
      },
      (error)=>{
        console.log(error);
        Swal.fire('Error',"Error in loading data");
      }

    )
  }

  //delete WashPack
  deleteWash(id:any){
    Swal.fire({
      icon:'info',
      title:'Are you sure ?',
      confirmButtonText:'Delete',
      showCancelButton:true,
}).then((result)=>{
  if(result.isConfirmed)
  {
    this._wash.deleteWashPack(id).subscribe(
      (data)=>{
        this.washPacks=this.washPacks.filter((wash)=>wash.id!=id);
        Swal.fire('Success','washPack deleted','success');
      },(error)=>{
        Swal.fire('Error','Error in deleting washPack','error');
      }
      );
  }
})
   
  }

}
