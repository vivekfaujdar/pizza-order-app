import { Component } from '@angular/core';
import { Product } from '../data-type';
import { FormsModule } from '@angular/forms';
import { ProductService } from '../services/product.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-admin-add-product',
  standalone: true,
  imports: [FormsModule,CommonModule],
  templateUrl: './admin-add-product.component.html',
  styleUrls: ['./admin-add-product.component.css'] // Note: Changed from `styleUrl` to `styleUrls`
})
export class AdminAddProductComponent {
  product: Product = {
    id: 0,
    name: '',
    type: '',
    pizzaSize: '',
    price: 0,
    description: '',
    imageUrl: '',
    crustType: '',
    toppings: ''
  };
  addProductMessage: string | undefined;

  constructor(private productService: ProductService) {}

  submit(data: Product) {
    this.productService.addProduct(data).subscribe((result) => {
      console.warn(result);
      if (result) {
        this.addProductMessage = 'Product is added successfully';
        this.resetForm();
      }
    });
    setTimeout(() => {
      this.addProductMessage = undefined;
    }, 3000);
  }

  resetForm() {
    this.product = {
      id: 0,
      name: '',
      type: '',
      pizzaSize: '',
      price: 0,
      description: '',
      imageUrl: '',
      crustType: '',
      toppings: ''
    };
  }
}
