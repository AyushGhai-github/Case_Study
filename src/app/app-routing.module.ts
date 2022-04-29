import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddCategoriesComponent } from './pages/admin/add-categories/add-categories.component';
import { AddLeaderboardComponent } from './pages/admin/add-leaderboard/add-leaderboard.component';
import { AddWashPackComponent } from './pages/admin/add-wash-pack/add-wash-pack.component';
import { AddWasherComponent } from './pages/admin/add-washer/add-washer.component';
import { AdminOrderComponent } from './pages/admin/admin-order/admin-order.component';
import { DashboardComponent } from './pages/admin/dashboard/dashboard.component';
import { LeaderBoardComponent } from './pages/admin/leader-board/leader-board.component';
import { ManageWasherComponent } from './pages/admin/manage-washer/manage-washer.component';
import { UpdateLeaderboardComponent } from './pages/admin/update-leaderboard/update-leaderboard.component';
import { UpdateWashPackComponent } from './pages/admin/update-wash-pack/update-wash-pack.component';
import { ViewCategoriesComponent } from './pages/admin/view-categories/view-categories.component';
import { ViewCustomerComponent } from './pages/admin/view-customer/view-customer.component';
import { WashPackComponent } from './pages/admin/wash-pack/wash-pack.component';
import { WelcomeComponent } from './pages/admin/welcome/welcome.component';
import { HomeComponent } from './pages/home/home.component';
import { LoginComponent } from './pages/login/login.component';
import { ProfileComponent } from './pages/profile/profile.component';
import { SignupComponent } from './pages/signup/signup.component';
import { AddOrderComponent } from './pages/user/add-order/add-order.component';
import { CustomerProfileComponent } from './pages/user/customer-profile/customer-profile.component';
import { PaymentGatewayComponent } from './pages/user/payment-gateway/payment-gateway.component';
import { RatingComponent } from './pages/user/rating/rating.component';
import { UserDashboardComponent } from './pages/user/user-dashboard/user-dashboard.component';
import { UserHomeComponent } from './pages/user/user-home/user-home.component';
import { UserOrderComponent } from './pages/user/user-order/user-order.component';
import { UserWashPackComponent } from './pages/user/user-wash-pack/user-wash-pack.component';
import { TakeRatingComponent } from './pages/washer/take-rating/take-rating.component';
import { ViewLeaderboardComponent } from './pages/washer/view-leaderboard/view-leaderboard.component';
import { ViewOrderComponent } from './pages/washer/view-order/view-order.component';
import { WasherDashboardComponent } from './pages/washer/washer-dashboard/washer-dashboard.component';
import { WasherHomeComponent } from './pages/washer/washer-home/washer-home.component';
import { WasherProfileComponent } from './pages/washer/washer-profile/washer-profile.component';
import { AdminGuard } from './services/admin.guard';
import { CustomerGuard } from './services/customer.guard';

const routes: Routes = [
  {
    path:'',
    component:HomeComponent,
    pathMatch:'full'
  },

  {
    path:'signup',
    component:SignupComponent,
    pathMatch:'full'
  },
  {
    path:'login',
    component:LoginComponent,
    pathMatch:'full'
  },

  {
    path:'admin',
    component:DashboardComponent,
    // pathMatch:'full',
    // canActivate:[AdminGuard],
    children:[
      {
        path: '',
      component: WelcomeComponent,
      },
      {
        path: 'profile',
        component: ProfileComponent,
      },
      {
        path: 'categories',
        component: ViewCategoriesComponent,
      },
      {
        path: 'add-categories',
        component: AddCategoriesComponent,
      },
      {
        path: 'washPack',
        component: WashPackComponent,
      },
      {
        path: 'add-washPack',
        component: AddWashPackComponent,
      },
      {
        path: 'washPack1/:wid',
        component: UpdateWashPackComponent,
      },
      {
        path:'manageWasher',
        component:ManageWasherComponent
      },
      {
          path:'viewCustomer',
          component:ViewCustomerComponent
      },
      {
        path:'leaderboard',
        component:LeaderBoardComponent
      },
      {
        path:'add-leaderboard',
        component:AddLeaderboardComponent
      },
      {
        path:'manage-order',
        component:AdminOrderComponent
      },
      {
        path:'add-washer',
        component:AddWasherComponent
      },
      {
        path: 'updateLeaderboard/:rank',
        component:UpdateLeaderboardComponent
      }
      
      

    ],
    
  },

  {
    path:'customer',
    component:UserDashboardComponent,
    // canActivate:[CustomerGuard],
   
    children:[
      {
        path: '',
        component:UserHomeComponent,
      },
      {
          path: 'profile',
        component: CustomerProfileComponent,
        },
        {
          path: 'washPack',
        component: UserWashPackComponent,
        },
        {
          path: 'myOrders',
        component:UserOrderComponent,
        },
        {
          path:'add-order',
          component:AddOrderComponent
        },
        {
          path:'add-rating',
          component:RatingComponent
        },
        {
          path:'payment-gateway',
          component:PaymentGatewayComponent
        },
        {
          path: 'order/:wid',
          component: AddOrderComponent,
        },
    ]
  },
  {
    path:"washer",
    component:WasherDashboardComponent,
    children:[
      {
      path:'',
      component:WasherHomeComponent
      },
      {
        path:'view-leaderboard',
        component:ViewLeaderboardComponent
      },
      {
        path:'washer-profile',
        component:WasherProfileComponent
      },
      {
        path:'washer-order',
        component:ViewOrderComponent
      },
      {
        path:'view-rating',
        component:TakeRatingComponent
      }
      
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
