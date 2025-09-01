import { Component, OnInit } from '@angular/core';
import { ProductService } from '../services/product.service';
import { Product } from '../data-type';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-admin-dashboard',
  standalone: true,
  imports: [FormsModule,CommonModule,RouterModule],
  templateUrl: './admin-dashboard.component.html',
  styleUrl: './admin-dashboard.component.css'
})
export class AdminDashboardComponent implements OnInit {
  productList: undefined | Product[];
  productMessage: undefined | string;
  constructor(private product: ProductService) {}
  ngOnInit(): void {
    this.list();
  }
  list() {
    this.product.productList().subscribe((result) => {
      if (result) {
        this.productList = result;
      }
    });
  }
  deleteProduct(id: number) {
    this.product.deleteProduct(id).subscribe((result) => {
      if (result) {
        this.productMessage = 'Product is deleted';

        this.list();
      }
    });
    setTimeout(() => {
      this.productMessage = undefined;
    }, 3000);
  }

}
