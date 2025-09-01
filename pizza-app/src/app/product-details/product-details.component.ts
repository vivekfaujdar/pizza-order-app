import { Component } from '@angular/core';
import { ActivatedRoute, RouterModule } from '@angular/router';
import { ProductService } from '../services/product.service';
import { Coupon, CurrentOrder, OrderDetails, OrderMaster, Product } from '../data-type';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { CouponService } from '../services/coupon.service';
import { OrderService } from '../services/order.service';

@Component({
  selector: 'app-product-details',
  standalone: true,
  imports: [CommonModule,FormsModule, RouterModule],
  templateUrl: './product-details.component.html',
  styleUrl: './product-details.component.css'
})
export class ProductDetailsComponent {
  productData: undefined | Product;
  productQuantity: number = 1;
  couponCode: string = ''; // For coupon input
  finalPrice: number = 0; // For price calculation
  couponError: string | undefined; // For error handling
  orderDetails: undefined | OrderDetails
  currentOrder: undefined | CurrentOrder
  // orderService: any;
  couponData!:Coupon
  orderMaster!:OrderMaster

  constructor(
    private activeRoute: ActivatedRoute,
    private orderService:OrderService, 
    private productService: ProductService,
    private couponService: CouponService 
  ) {}

  ngOnInit(): void {
    let productId = this.activeRoute.snapshot.paramMap.get('id');
    console.warn(productId);
    
    productId && this.productService.getProduct(productId).subscribe((result) => {
      this.productData = result;
      if (this.productData) {
        this.finalPrice = this.productData.price; 

        this.orderDetails = {
          orderId: 0, 
          quantity: this.productQuantity,
          unitPrice: this.productData.price,
          totalPrice: this.calculateTotalPrice(this.productData.price, this.productQuantity),
          pizzaId: this.productData.id 
        };

      }
    });
  }
  calculateTotalPrice(unitPrice: number, quantity: number): number {
    return unitPrice * quantity;
  }
  // Method to apply coupon
  applyCoupon() {
    this.couponError = undefined; 

    // Fetch coupon by code
    this.couponService.getCouponByCode(this.couponCode).subscribe((coupon: Coupon) => {
      this.couponData=coupon
      const currentDate = new Date();
      const expirationDate = new Date(coupon.expirationDate);

      // Check if the coupon is not expired
      if (expirationDate >= currentDate) {
        // Apply discount and calculate the final price
        const discountAmount = (coupon.discountPercentage / 100) * this.productData!.price;
        this.finalPrice = this.productData!.price - discountAmount;
      } else {
        this.couponError = 'Coupon has expired.';
      }
    }, () => {
      this.couponError = 'Invalid coupon code.'; // If coupon is not found
    });
  }

  handleQuantity(val:string){
    if(this.productQuantity<20 && val==='plus'){
      this.productQuantity+=1;
    }else if(this.productQuantity>1 && val==='min'){
      this.productQuantity-=1;
    }
  }


  addToCart(){
    if(this.productData){
      // this.productData.quantity = this.productQuantity;
      if(!localStorage.getItem('customer')){
        this.productService.localAddToCart(this.productData);
        //this.removeCart=true
      }else{
        let customer = localStorage.getItem('customer');
        let custId= customer && JSON.parse(customer).id;
        // let cartData:cart={
        //   ...this.productData,
        //   productId:this.productData.id,
        //   userId
        // }
      }
    }
  }
  buyNow() {
    console.log(this.productData)
    if (this.productData) {
      console.log(this.productData)
      const orderMaster: OrderMaster = {
        orderDate: new Date().toISOString(),
        status: 'CONFIRMED', 
        totalPrice: this.productQuantity * this.productData.price,
        finalPriceAfterDiscount: this.productQuantity * this.finalPrice,
        customerId: 1,
        // couponId: this.couponData.couponId 
      };
      console.log(orderMaster)
      // Call OrderService to create a new order
      this.orderService.createOrder(orderMaster)
      .subscribe((order) => {
        console.log(order)
        //this.router.navigate(['/order-confirmation', order.orderMasterId]);
      });
    }
  }
  
}
