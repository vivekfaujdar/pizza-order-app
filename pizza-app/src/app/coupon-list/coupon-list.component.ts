import { Component } from '@angular/core';
import { Coupon } from '../data-type';
import { CouponService } from '../services/coupon.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-coupon-list',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './coupon-list.component.html',
  styleUrl: './coupon-list.component.css'
})
export class CouponListComponent {
  coupons: Coupon[] = [];

  constructor(private couponService: CouponService) {}

  ngOnInit(): void {
    this.loadCoupons();
  }

  // Fetch the list of coupons from the server
  loadCoupons() {
    this.couponService.getAllCoupons().subscribe((coupons: Coupon[]) => {
      this.coupons = coupons;
    });
  }
}
