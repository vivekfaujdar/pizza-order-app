import { Component } from '@angular/core';
import { CustomerService } from '../services/customer.service';
import { Customer } from '../data-type';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-customer-register',
  standalone: true,
  imports: [CommonModule,FormsModule, RouterModule],
  templateUrl: './customer-register.component.html',
  styleUrls: ['./customer-register.component.css']
})
export class CustomerRegisterComponent {
  customer: Customer = {
    id:0,
    name: '',
    email: '',
    birthdate: '',
    mobile: 0,
    address: '',
    password: ''
  };

  constructor(private customerService: CustomerService) {}

  registerCustomer(data:Customer) {
    if (this.customer) {
      this.customerService.userSignUp(data);
    }
  }
}
