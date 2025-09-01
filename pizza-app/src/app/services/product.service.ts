import { EventEmitter, Injectable, Output } from '@angular/core';
import { Product } from '../data-type';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class  ProductService {
  private baseUrl = 'http://localhost:8081/api/pizzas';
  constructor(private http: HttpClient) { }

  addProduct(data: Product) {
    return this.http.post(this.baseUrl, data);
  }
  productList() {
    return this.http.get<Product[]>(this.baseUrl);
  }

  deleteProduct(id: number) {
    return this.http.delete(`${this.baseUrl}/${id}`);
  }

  getProduct(id: string) {
    return this.http.get<Product>(`${this.baseUrl}/${id}`);
  }

  updateProduct(product: Product) {
    return this.http.put<Product>(
      `${this.baseUrl}/${product.id}`,
      product
    );
  }
  popularProducts() {
    return this.http.get<Product[]>(`${this.baseUrl}?_limit=3`);
  }

  // trendyProducts() {
  //   return this.http.get<Product[]>('http://localhost:3000/products?_limit=8');
  // }
  // searchProduct(query: string) {
  //   return this.http.get<Product[]>(
  //     `http://localhost:3000/products?q=${query}`
  //   );
  // }
  @Output() cartData: EventEmitter<Product[]> = new EventEmitter<Product[]>();

  localAddToCart(data: Product) {
    let cartData = [];
    let localCart = localStorage.getItem('localCart');
    if (!localCart) {
      localStorage.setItem('localCart', JSON.stringify([data]));
      this.cartData.emit([data]);
    } else {
      cartData = JSON.parse(localCart);
      cartData.push(data);
      localStorage.setItem('localCart', JSON.stringify(cartData));
      this.cartData.emit(cartData);
    }
  }
}
