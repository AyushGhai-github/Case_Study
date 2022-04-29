import { Component, OnInit } from '@angular/core';
import { ViewLeaderboardService } from '../view-leaderboard.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-view-leaderboard',
  templateUrl: './view-leaderboard.component.html',
  styleUrls: ['./view-leaderboard.component.css']
})
export class ViewLeaderboardComponent implements OnInit {
  Leaderboard=[
    {
      "rank":1,
      "washerName":"Ayush Ghai",
      "waterSavedInLiters":10000,
      "workingHrs":182
    }
  ]

  constructor(private _leader:ViewLeaderboardService) { }

  ngOnInit(): void {
    this._leader.leaderboard().subscribe(
      (data:any)=>{
        this.Leaderboard=data;
        console.log(this.Leaderboard)
      },
      (error)=>{
        console.log(error);
        Swal.fire('Error',"Error in loading data");
      }

    )
  }
  }


