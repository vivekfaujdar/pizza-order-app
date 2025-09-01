import { EventEmitter, Injectable } from '@angular/core';
import { Customer, CustomerLogin } from '../data-type';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  isLoginError=new EventEmitter<boolean>(false)
  private baseUrl = 'http://localhost:8081/api/customers'; 

  constructor(private http: HttpClient, private router:Router) { }
  
  userSignUp(user:Customer){
    this.http.post(this.baseUrl,user,{observe:'response'})
    .subscribe((result)=>{
     if(result){
       localStorage.setItem('customer',JSON.stringify(result.body));
       this.router.navigate(['/']);
     }
     
    })
     
   }

   login(data: CustomerLogin) {
    this.http.post(`${this.baseUrl}/login`, data, {observe:'response'})
    .subscribe((result)=>{
     if(result){
       localStorage.setItem('customer',JSON.stringify(result.body));
       this.router.navigate(['/']);
     }else {

      console.log("login failed")
      this.isLoginError.emit(true)
    }
     
    })
  }
}
