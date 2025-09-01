import { Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { AdminAuthComponent } from './admin-auth/admin-auth.component';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { authGuard } from './auth.guard';
import { AdminAddProductComponent } from './admin-add-product/admin-add-product.component';
import { AdminUpdateProductComponent } from './admin-update-product/admin-update-product.component';
import { ProductDetailsComponent } from './product-details/product-details.component';
import { AdminAddCouponComponent } from './admin-add-coupon/admin-add-coupon.component';
import { ProductCheckoutComponent } from './product-checkout/product-checkout.component';
import { CustomerRegisterComponent } from './customer-register/customer-register.component';
import { CustomerAuthComponent } from './customer-auth/customer-auth.component';
import { OrderComponent } from './order/order.component';
import { CouponListComponent } from './coupon-list/coupon-list.component';
import { CartComponent } from './cart/cart.component';

export const routes: Routes = [
    
    {path:'', component: HomeComponent},
    {path:'admin-auth', component: AdminAuthComponent},
    {path:'admin-dashboard', component: AdminDashboardComponent, canActivate:[authGuard]},
    {path:'admin-add-product', component:AdminAddProductComponent, canActivate:[authGuard]},
    {path:'admin-update-product/:id', component:AdminUpdateProductComponent, canActivate:[authGuard]},
    {path:'details/:id', component: ProductDetailsComponent},
    {path:'admin-add-coupon', component:AdminAddCouponComponent, canActivate:[authGuard]},
    {path:'checkout/:id', component: ProductCheckoutComponent},
    {path:'customer-register', component: CustomerRegisterComponent},
    {path:'customer-auth', component: CustomerAuthComponent},
    {path:'order', component:OrderComponent},
    {path:'coupons-list', component:CouponListComponent, canActivate:[authGuard]},
    {path:'cart', component:CartComponent}
];
