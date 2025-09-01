import { Component } from '@angular/core';
import { AdminService } from '../services/admin.service';
import { FormsModule } from '@angular/forms';
import { Login } from '../data-type';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-admin-auth',
  standalone: true,
  imports: [FormsModule,CommonModule],
  templateUrl: './admin-auth.component.html',
  styleUrl: './admin-auth.component.css'
})
export class AdminAuthComponent {
  loginForm:Login={
    email:'',
    password:''
  }
  authError:string='';
  constructor(private adminService:AdminService){ }

  login(data:Login):void{
    // console.log(data)
    this.adminService.adminLogin(data);
    this.adminService.isLoginError.subscribe((isError)=>{
      if(isError){
        this.authError="Email Or Password is not correct"
      }
    })
  }
  // login(data:Login):void{
  //   // console.log(data)
  //   this.adminService.adminLogin(data).subscribe((result:any)=>{
  //     console.warn(result);
  //     if(result){
  //       this.authError="Login successful!";
  //       this.resetForm();
  //     }
  //   });
  //   setTimeout(() => {
  //     this.authError = '';
  //   }
  // }
    
  // resetForm() {
  //   this.loginForm = {
  //     email:'',
  //   password:''
  //   };
  // }
  // login(data: Login): void {
  //   this.adminService.adminLogin(data).subscribe({
  //     next: (response) => {
  //       // Handle successful login (e.g., redirect, store token, etc.)
  //       console.log('Login successful!', response);
  //       // Perform actions like redirecting the user
  //     },
  //     error: (err) => {
  //       // Handle login error
  //       console.error('Login failed:', err);
  //       this.authError = 'Email or Password is incorrect';
  //     }
  //   });
  // }
  // authError: string = '';  // To store error message

  // constructor(private adminService: AdminService) {}

  // login(data: Login): void {
  //   this.adminService.adminLogin(data).subscribe(
  //     (response) => {
  //       console.log(response)
  //       this.router.navigate(['/admin-dashboard']); 
  //     },
  //     (error) => {
  //       // handle error here, display message
  //       this.authError = 'Email or Password is incorrect';
  //     }
  //   );
  // }
}
