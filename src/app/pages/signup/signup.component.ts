import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { UserService } from 'src/app/services/user.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  constructor(private userService:UserService,private snack:MatSnackBar) { }

  public user={
    username:'',
    password:'',
    customerEmail:'',
    customerName:'',
    customerAddress:'',
    customerContactNo:'',
    role:""

  }

  ngOnInit(): void {
  }



  formSubmit()
  {
    console.log(this.user);
    if(this.user.username=='' || this.user.username==null)
    {
      // alert("user is required !!")
      this.snack.open("Username is Required !!",'',{
        duration:3000,
        // verticalPosition:'top'
      });
      return;
    }
     //Add user-User-service
     this.userService.addUser(this.user).subscribe(
       (data) => {
         //success
         console.log(data);
        //  alert("Registered!!");
        Swal.fire('Success','User is Registered','success');
       },
       (error) => {
         //error
         console.log(error);
        //  alert('Something went Wrong');
        this.snack.open("Something went Wrong",'',{
          duration:3000,
          // verticalPosition:'top'
        });
       }
       
     );

  }

 

}
