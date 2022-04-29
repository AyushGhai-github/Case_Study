import { Component, OnInit } from '@angular/core';
import { LeaderboardService } from '../leaderboard.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-leader-board',
  templateUrl: './leader-board.component.html',
  styleUrls: ['./leader-board.component.css']
})
export class LeaderBoardComponent implements OnInit {
  Leaderboard=[
    {
      "rank":1,
      "washerName":"Ayush Ghai",
      "waterSavedInLiters":10000,
      "workingHrs":182
    }
  ]

  constructor(private _leader:LeaderboardService) { }


    
  ngOnInit(): void {
    this._leader.Leaderboard().subscribe(
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


