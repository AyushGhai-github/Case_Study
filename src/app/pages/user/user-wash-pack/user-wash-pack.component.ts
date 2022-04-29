import { Component, OnInit } from '@angular/core';
import { WashPackService } from 'src/app/services/wash-pack.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-user-wash-pack',
  templateUrl: './user-wash-pack.component.html',
  styleUrls: ['./user-wash-pack.component.css']
})
export class UserWashPackComponent implements OnInit {
  washPacks=[
    {
      id:"",
      "packName":"",
      "amount":"",
      
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

}
