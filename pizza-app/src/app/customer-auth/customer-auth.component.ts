import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { CustomerService } from '../services/customer.service';
import { CustomerLogin } from '../data-type';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-customer-auth',
  standalone: true,
  imports: [FormsModule,CommonModule],
  templateUrl: './customer-auth.component.html',
  styleUrls: ['./customer-auth.component.css']
})
export class CustomerAuthComponent {
  loginData: CustomerLogin = { email: '', password: '' };
  authError:string='';
  constructor(private customerService: CustomerService, private router: Router) {}

  onSubmit(data:CustomerLogin):void {
    this.customerService.login(data);
    this.customerService.isLoginError.subscribe((isError)=>{
      if(isError){
        this.authError="Email Or Password is not correct"
      }
    })

    // .subscribe(
    //     response => {
    //       // handle success (store user data, navigate, etc.)
    //       console.log('Login successful!', response);
    //       this.router.navigate(['/']);
    //     },
    //     error => {
    //       // handle error (invalid credentials, etc.)
    //       console.log('Login failed.', error);
    //     }
    //   );
    }
  }