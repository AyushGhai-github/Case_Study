import { Component, OnInit } from '@angular/core';
import { RatingService } from '../../user/rating.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-take-rating',
  templateUrl: './take-rating.component.html',
  styleUrls: ['./take-rating.component.css']
})
export class TakeRatingComponent implements OnInit {

 ratings=[{
    // "washerName": null,
    "rating": "",
    "review": ""
 }
 ]

  constructor(private _rate:RatingService) { }

  ngOnInit(): void {
    this._rate.Ratings().subscribe(
      (data:any)=>{
        this.ratings=data;
        console.log(this.ratings)
      },
      (error)=>{
        console.log(error);
        Swal.fire('Error',"Error in loading data");
      }

    )
  }

}
