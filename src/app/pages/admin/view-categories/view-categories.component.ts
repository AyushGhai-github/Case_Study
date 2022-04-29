import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-view-categories',
  templateUrl: './view-categories.component.html',
  styleUrls: ['./view-categories.component.css']
})
export class ViewCategoriesComponent implements OnInit {

  categories=[{
    first:'washPack',
    description:'Customer can Choose washPack according to Them'
  },
   {
     first:'Order-Details',
     description:'You can manage your order details from here',
   },
   {
    first:'Manage-Washer',
    description:'You can see  Washer details from here',
   },
   {
    first:'view-Customer',
    description:'You can see active customer  details from here',
   }
]

  constructor() { }

  ngOnInit(): void {
  }

}
