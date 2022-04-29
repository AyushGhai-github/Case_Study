import { Component, OnInit } from '@angular/core';
import Swal from 'sweetalert2';
import { MatSnackBar } from '@angular/material/snack-bar';
import { AddWasherService } from '../add-washer.service';

@Component({
  selector: 'app-add-washer',
  templateUrl: './add-washer.component.html',
  styleUrls: ['./add-washer.component.css']
})
export class AddWasherComponent implements OnInit {
  washer={
    "id": "",
    "username": "",
    "password": "",
    "washerName": "",
    "contactNo": "",
    "washerEmail": "",
    "washerAddress": "",
    "role": ""
  }

  constructor(private _snack:MatSnackBar,private _add:AddWasherService) { }

  ngOnInit(): void {
  }
  addWasher()
  {
    if(this.washer.washerName.trim()=='' || this.washer.washerName==null)
    {
      this._snack.open("Washer Name Required","",{
        duration:3000,

      });
      return;
    }
    //to add data from server
    this._add.addWasher(this.washer).subscribe(
      (data)=>{
        Swal.fire('Success','WashPack is Added','success');
        this.washer={
          "id": "",
          "username": "",
          "password": "",
          "washerName": "",
          "contactNo": "",
          "washerEmail": "",
          "washerAddress": "",
          "role": ""
        }

      },
    (error)=>{
      Swal.fire("Error!!",'Error while adding WashPack','error')
      console.log(error)
    })
  }


}
