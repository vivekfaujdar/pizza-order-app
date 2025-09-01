import { Component } from '@angular/core';
import { Coupon } from '../data-type';
import { CouponService } from '../services/coupon.service';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { NgbDatepickerModule } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-admin-add-coupon',
  standalone: true,
  imports: [FormsModule, CommonModule, NgbDatepickerModule],
  templateUrl: './admin-add-coupon.component.html',
  styleUrls: ['./admin-add-coupon.component.css']
})
export class AdminAddCouponComponent {
  coupon: Coupon = {
    couponId: 0,
    couponCode: '',
    discountPercentage: 0,
    expirationDate: ''
  };
  
  addCouponMessage: string | undefined;

  constructor(private couponService: CouponService) {}

  submit(data: any) {
    // Map form values to coupon object
    const couponData: Coupon = {
      couponId: this.coupon.couponId, // Assuming id is auto-generated on the server side
      couponCode: data.couponCode || '',
      discountPercentage: data.discountPercentage || 0,
      expirationDate: data.expirationDate || ''
    };

    this.couponService.addCoupon(couponData).subscribe((result) => {
      console.warn(result);
      if (result) {
        this.addCouponMessage = 'Coupon added successfully';
        this.resetForm();
      }
    });
    setTimeout(() => {
      this.addCouponMessage = undefined;
    }, 3000);
  }

  resetForm() {
    this.coupon = {
      couponId: 0,
      couponCode: '',
      discountPercentage: 0,
      expirationDate: ''
    };
  }
}
