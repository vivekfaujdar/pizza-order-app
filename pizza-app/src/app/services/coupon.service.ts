import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Coupon } from '../data-type';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CouponService {
  private baseUrl = 'http://localhost:8081/api/coupons';
  constructor(private http: HttpClient) { }

  addCoupon(data: Coupon) {
    return this.http.post(this.baseUrl, data);
  }
  getCouponByCode(code: string): Observable<Coupon> {
    return this.http.get<Coupon>(`${this.baseUrl}/code/${code}`);
  }

  getAllCoupons(): Observable<Coupon[]> {
    return this.http.get<Coupon[]>(`${this.baseUrl}`);
  }
  
}
