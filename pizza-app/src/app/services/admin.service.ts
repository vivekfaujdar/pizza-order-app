import { HttpClient } from '@angular/common/http';
import { EventEmitter, Injectable } from '@angular/core';
import { BehaviorSubject, map, Observable } from 'rxjs';
import { Login } from '../data-type';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AdminService {
  isAdminLoggedIn=new BehaviorSubject<boolean>(false);

  isLoginError=new EventEmitter<boolean>(false)
  private baseUrl = 'http://localhost:8081/api/admins'; 

  constructor(private http: HttpClient, private router:Router) {}

  adminLogin(data:Login){
    console.log(data)
    this.http.post(`${this.baseUrl}/login`,data, 
      {observe:'response'}).subscribe((result:any)=>{
        console.log(result)
        if(result && result.body){
          console.log("admin logged")
          localStorage.setItem('admin', JSON.stringify(result.body))
          this.router.navigate(['/admin-dashboard'])
        }else {

          console.log("login failed")
          this.isLoginError.emit(true)
        }
      })
  }
  reloadAdmin(){
    if(localStorage.getItem('admin')){
      this.isAdminLoggedIn.next(true)
      this.router.navigate(['admin-dashboard'])
    }
  }
  login(email: string, password: string): Observable<boolean> {
    return this.http.post<any>(this.baseUrl, { email, password }).pipe(
      map(response => {
        // Assuming the backend returns a token on successful login
        if (response && response.token) {
          localStorage.setItem('adminToken', response.token);
          return true;
        }
        return false;
      })
    );
  }
}
