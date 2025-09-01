import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { OrderService } from '../services/order.service';
import { CouponService } from '../services/coupon.service';
import { OrderMaster, OrderDetails, Coupon } from '../data-type';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-order-details',
  standalone:true,
  imports:[CommonModule, FormsModule],
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit {
  order: OrderMaster | null = null;
  couponCode: string = '';
  discountAmount: number = 0;
  finalPrice: number = 0;
  couponError: string | null = null;

  constructor(
    private orderService: OrderService,
    private couponService: CouponService,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
  //   // Fetch orderId from route parameters and load order details
  //   const orderId = this.route.snapshot.paramMap.get('orderId');
  //   if (orderId) {
  //     this.loadOrderDetails(+orderId);
  //   }
  }

  // Load the order details by orderId
  // loadOrderDetails(orderId: number) {
  //   this.orderService.getOrderById(orderId).subscribe((order: OrderMaster) => {
  //     this.order = order;
  //     this.finalPrice = order.totalPrice;
  //   });
  // }

  // // Apply coupon and recalculate final price
  // applyCoupon() {
  //   if (this.couponCode.trim()) {
  //     this.couponService.getCouponByCode(this.couponCode).subscribe(
  //       (coupon: Coupon) => {
  //         if (coupon) {
  //           this.discountAmount = (this.order?.totalPrice || 0) * (coupon.discountPercentage / 100);
  //           this.finalPrice = (this.order?.totalPrice || 0) - this.discountAmount;
  //           this.couponError = null;
  //         }
  //       },
  //       (error) => {
  //         this.couponError = 'Invalid coupon code';
  //         this.discountAmount = 0;
  //         this.finalPrice = this.order?.totalPrice || 0;
  //       }
  //     );
  //   }
  // }
}
