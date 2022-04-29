import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { WashPackService } from 'src/app/services/wash-pack.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-add-wash-pack',
  templateUrl: './add-wash-pack.component.html',
  styleUrls: ['./add-wash-pack.component.css']
})
export class AddWashPackComponent implements OnInit {

  WashPackData={
    "id":"",
    "packName":"",
    "amount":""
  }

  constructor(private _snack:MatSnackBar,private _add:WashPackService) { }

  ngOnInit(): void {
  }
  addWashPack()
  {
    if(this.WashPackData.packName.trim()=='' || this.WashPackData.packName==null)
    {
      this._snack.open("WashPack Name Required","",{
        duration:3000,

      });
      return;
    }
    //to add data from server
    this._add.addWashPack(this.WashPackData).subscribe(
      (data)=>{
        Swal.fire('Success','WashPack is Added','success');
        this.WashPackData={
          "id":"",
          "packName":"",
          "amount":"",
        }

      },
    (error)=>{
      Swal.fire("Error!!",'Error while adding WashPack','error')
      console.log(error)
    })
  }

}
