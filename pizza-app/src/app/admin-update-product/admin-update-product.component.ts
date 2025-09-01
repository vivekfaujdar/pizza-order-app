import { Component } from '@angular/core';
import { ProductService } from '../services/product.service';
import { Product } from '../data-type';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-admin-update-product',
  standalone: true,
  imports: [FormsModule, RouterModule, CommonModule],
  templateUrl: './admin-update-product.component.html',
  styleUrl: './admin-update-product.component.css'
})
export class AdminUpdateProductComponent {
  product: Product = {
    id:0,
    name: '',
    type: '',
    pizzaSize: '',
    price: 0,
    description: '',
    imageUrl: '',
    crustType: '',
    toppings: ''
  };
  productData: undefined | Product;
  productMessage: undefined | string;
  constructor(private router: Router, private route: ActivatedRoute, private productService: ProductService) {}

  ngOnInit(): void {
    let productId = this.route.snapshot.paramMap.get('id');
    console.warn(productId);
    productId &&
      this.productService.getProduct(productId).subscribe((data) => {
        console.warn(data);
        this.productData = data;
      });
  }
  submit(data: Product) {
    if (this.productData) {
      data.id = this.productData.id;
    }
    this.productService.updateProduct(data).subscribe((result) => {
      if (result) {
        this.productMessage = 'Product has updated';
        this.router.navigate(['/admin-dashboard']);
      }
    });
    setTimeout(() => {
      this.productMessage = undefined;
    }, 3000);
    console.warn(data);
  }
}
