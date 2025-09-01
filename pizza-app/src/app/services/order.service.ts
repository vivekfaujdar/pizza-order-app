import { Injectable } from '@angular/core';
import { OrderDetails, OrderMaster } from '../data-type';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  private baseUrl = 'http://localhost:8081/api/orders'; // Your backend API URL

  constructor(private http: HttpClient) {}

  // createOrder(orderDetails: OrderDetails): Observable<OrderDetails> {
  //   return this.http.post<OrderDetails>(this.baseUrl, orderDetails);
  // }


  // Get all orders
  getAllOrders(): Observable<OrderMaster[]> {
    return this.http.get<OrderMaster[]>(`${this.baseUrl}`);
  }

  // Get order by ID
  getOrderById(id: number): Observable<OrderMaster> {
    return this.http.get<OrderMaster>(`${this.baseUrl}/${id}`);
  }

  // Create new order
  createOrder(order: OrderMaster): Observable<OrderMaster> {
    return this.http.post<OrderMaster>(`${this.baseUrl}`, order);
  }

  // Update an existing order
  updateOrder(id: number, order: OrderMaster): Observable<OrderMaster> {
    return this.http.put<OrderMaster>(`${this.baseUrl}/${id}`, order);
  }

  // Delete an order by ID
  deleteOrder(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/${id}`);
  }
}
