import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { RatingService } from '../rating.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-rating',
  templateUrl: './rating.component.html',
  styleUrls: ['./rating.component.css']
})
export class RatingComponent implements OnInit {

  ratings={
    // "washerName":"",
    "rating": "",
    "review": ""
  }

  constructor(private _snack:MatSnackBar,private _add:RatingService) { }

  ngOnInit(): void {
  }
  addRating()
  {
    if(this.ratings.review.trim()=='' || this.ratings.review==null)
    {
      this._snack.open("WasherName is  Required","",{
        duration:3000,

      });
      return;
    }
    //to add data from server
    this._add.addRating(this.ratings).subscribe(
      (data)=>{
        Swal.fire('Success','Thanks For giving Rating','success');
        this.ratings={
          // "washerName":"",
          "rating": "",
          "review": ""
        }

      },
    (error)=>{
      Swal.fire("Error!!",'Error while adding WashPack','error')
      console.log(error)
    })
  }

}


