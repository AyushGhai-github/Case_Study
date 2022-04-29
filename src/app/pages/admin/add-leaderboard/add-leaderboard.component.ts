import { Component, OnInit } from '@angular/core';
import { LeaderboardService } from '../leaderboard.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import Swal from 'sweetalert2';
@Component({
  selector: 'app-add-leaderboard',
  templateUrl: './add-leaderboard.component.html',
  styleUrls: ['./add-leaderboard.component.css']
})
export class AddLeaderboardComponent implements OnInit {
  Leaderboard=
    {
      "rank":"",
      "washerName":"",
      "waterSavedInLiters":"",
      "workingHrs":""
    }

  constructor(private _snack:MatSnackBar,private _add:LeaderboardService) { }

  ngOnInit(): void {
  }

  addLeaderboard()
  {
    if(this.Leaderboard.washerName.trim()=='' || this.Leaderboard.washerName==null)
    {
      this._snack.open("washerName Name Required","",{
        duration:3000,

      });
      return;
    }
    //to add data from server
    this._add.addLeaderBoard(this.Leaderboard).subscribe(
      (data)=>{
        Swal.fire('Success','WashPack is Added','success');
        this.Leaderboard={
          "rank":"",
        "washerName":"",
        "waterSavedInLiters":"",
        "workingHrs":""
        }

      },
    (error)=>{
      Swal.fire("Error!!",'Error while adding new washer name','error')
      console.log(error)
    })
  }


}
