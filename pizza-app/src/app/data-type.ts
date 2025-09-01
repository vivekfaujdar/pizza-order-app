import { NgbDateStruct } from "@ng-bootstrap/ng-bootstrap"

export interface Login{
    email: string
    password: string
}

export interface Product{
    id:number
    name:string
    type:string
    pizzaSize:string
    price:number
    description:string
    imageUrl:string
    crustType:string
    toppings:string
}

export interface Coupon{
    couponId:number
    couponCode:string
    discountPercentage:number
    expirationDate:string
}

export interface Customer{
    id:number
    name:string
    email:string
    birthdate:string
    mobile:number
    address:string
    password:string
}

export interface CustomerLogin{
    email:string
    password:string
}

// export interface OrderDetails {
//     orderId: number;
//     pizzaId: number;
//     orderMasterId: number;
//     quantity: number;
//     unitPrice: number;
//     totalPrice: number;
// }
export interface OrderDetails {
  orderId: number;
  quantity: number;
  unitPrice: number;
  totalPrice: number;
  pizzaId: number;  
 // orderMasterId: number;
}

export interface OrderMaster {
  orderMasterId?: number;
  orderDate: string;  // Use string for dates in Angular
  status: string;
  totalPrice: number;
  finalPriceAfterDiscount: number;
  customerId: number;  // Assuming you use customerId to map customer details
  couponId?: number;   // Optional if a coupon is applied
}

export interface CurrentOrder{
    product:undefined | Product
    quantity: number
}