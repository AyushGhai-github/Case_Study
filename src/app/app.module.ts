import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatButtonModule} from '@angular/material/button';
import { NavbarComponent } from './components/navbar/navbar.component';
import { FooterComponent } from './components/footer/footer.component';
import { SignupComponent } from './pages/signup/signup.component';
import { LoginComponent } from './pages/login/login.component';
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import { FormsModule } from '@angular/forms';
import { HttpClientModule} from '@angular/common/http';
import {MatSnackBarModule} from '@angular/material/snack-bar';
import { HomeComponent } from './pages/home/home.component';
import {MatCardModule} from '@angular/material/card';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatIconModule} from '@angular/material/icon';
import { DashboardComponent } from './pages/admin/dashboard/dashboard.component';
import { UserDashboardComponent } from './pages/user/user-dashboard/user-dashboard.component';
import { ProfileComponent } from './pages/profile/profile.component';
import {MatListModule} from '@angular/material/list';
import { SidebarComponent } from './pages/admin/sidebar/sidebar.component';
import { WelcomeComponent } from './pages/admin/welcome/welcome.component';
import {MatTableModule} from '@angular/material/table';
import { ViewCategoriesComponent } from './pages/admin/view-categories/view-categories.component';
import { AddCategoriesComponent } from './pages/admin/add-categories/add-categories.component';
import { WashPackComponent } from './pages/admin/wash-pack/wash-pack.component';
import { AddWashPackComponent } from './pages/admin/add-wash-pack/add-wash-pack.component';
import {MatSlideToggleModule} from '@angular/material/slide-toggle';
import {MatSelectModule} from '@angular/material/select';
import { UpdateWashPackComponent } from './pages/admin/update-wash-pack/update-wash-pack.component';
import { UserSidebarComponent } from './pages/user/user-sidebar/user-sidebar.component';
import { UserWashPackComponent } from './pages/user/user-wash-pack/user-wash-pack.component';
import { UserHomeComponent } from './pages/user/user-home/user-home.component';
import { UserOrderComponent } from './pages/user/user-order/user-order.component';
import { WasherDashboardComponent } from './pages/washer/washer-dashboard/washer-dashboard.component';
import { WasherSidebarComponent } from './pages/washer/washer-sidebar/washer-sidebar.component';
import { WasherHomeComponent } from './pages/washer/washer-home/washer-home.component';
import { ManageWasherComponent } from './pages/admin/manage-washer/manage-washer.component';
import { ViewCustomerComponent } from './pages/admin/view-customer/view-customer.component';
import { AddWasherComponent } from './pages/admin/add-washer/add-washer.component';
import {MatRadioModule} from '@angular/material/radio';
import { authInterceptorProviders } from './services/auth.interceptor';
import { LeaderBoardComponent } from './pages/admin/leader-board/leader-board.component';
import { AddLeaderboardComponent } from './pages/admin/add-leaderboard/add-leaderboard.component';
import { UpdateLeaderboardComponent } from './pages/admin/update-leaderboard/update-leaderboard.component';
import { ViewLeaderboardComponent } from './pages/washer/view-leaderboard/view-leaderboard.component';
import { WasherProfileComponent } from './pages/washer/washer-profile/washer-profile.component';
import { CustomerProfileComponent } from './pages/user/customer-profile/customer-profile.component';
import { AddOrderComponent } from './pages/user/add-order/add-order.component';
import { ViewOrderComponent } from './pages/washer/view-order/view-order.component';
import { AdminOrderComponent } from './pages/admin/admin-order/admin-order.component';
import { RatingComponent } from './pages/user/rating/rating.component';
import { TakeRatingComponent } from './pages/washer/take-rating/take-rating.component';
import { PaymentGatewayComponent } from './pages/user/payment-gateway/payment-gateway.component';




@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    FooterComponent,
    SignupComponent,
    LoginComponent,
    HomeComponent,
    DashboardComponent,
    UserDashboardComponent,
    ProfileComponent,
    SidebarComponent,
    WelcomeComponent,
    ViewCategoriesComponent,
    AddCategoriesComponent,
    WashPackComponent,
    AddWashPackComponent,
    UpdateWashPackComponent,
    UserSidebarComponent,
    UserWashPackComponent,
    UserHomeComponent,
    UserOrderComponent,
    WasherDashboardComponent,
    WasherSidebarComponent,
    WasherHomeComponent,
    ManageWasherComponent,
    ViewCustomerComponent,
    AddWasherComponent,
    LeaderBoardComponent,
    AddLeaderboardComponent,
    UpdateLeaderboardComponent,
    ViewLeaderboardComponent,
    WasherProfileComponent,
    CustomerProfileComponent,
    AddOrderComponent,
    ViewOrderComponent,
    AdminOrderComponent,
    RatingComponent,
    TakeRatingComponent,
    PaymentGatewayComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatInputModule,
    MatFormFieldModule,
    FormsModule,
    HttpClientModule,
    MatSnackBarModule,
    MatCardModule,
    MatToolbarModule,
    MatIconModule,
    MatListModule,
    MatTableModule,
    MatSlideToggleModule,
    MatSelectModule,
    MatRadioModule
  ],
  providers: [authInterceptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule { }
