import { Component } from '@angular/core';
import { ActivatedRoute, RouterModule } from '@angular/router';
import { OrderMaster } from '../data-type';

@Component({
  selector: 'app-product-checkout',
  standalone: true,
  imports: [RouterModule],
  templateUrl: './product-checkout.component.html',
  styleUrls: ['./product-checkout.component.css']
})
export class ProductCheckoutComponent {
  totalPrice: number = 0;
  orderMaster: OrderMaster;

  
  constructor(private route: ActivatedRoute) {
    this.orderMaster = {
      orderMasterId: 12345, 
      orderDate: '2024-09-20',
      status: 'Confirmed',
      totalPrice: 500,
      finalPriceAfterDiscount: 450,
      customerId: 1,
      couponId: 101
    };
  }

  ngOnInit(): void {
    // Get total price from query parameters (assuming it is passed when navigating to checkout page)
    this.route.queryParams.subscribe(params => {
      this.totalPrice = +params['totalPrice'] || 0; // Use + to convert the parameter to a number
    });
  }
}
