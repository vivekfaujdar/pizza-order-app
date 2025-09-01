import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { Router, RouterLink, RouterLinkActive } from '@angular/router';

@Component({
  selector: 'app-navbar',
  standalone: true,
  imports: [CommonModule, RouterLink, RouterLinkActive],
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.css'
})
export class NavbarComponent {
  menuType: string = 'default';
  adminName:string="";
  constructor(private route: Router) {}
  ngOnInit(): void {
    this.route.events.subscribe((val: any) => {
      console.log(val)
      if (val.url) {
        if (localStorage.getItem('admin') && val.url.includes('admin')) {
        //  let adminStore=localStorage.getItem('admin');
        //  let adminData =adminStore && JSON.parse(adminStore)[0];
        //  this.adminName=adminData.name;
         console.log(this.menuType)
          this.menuType = 'admin';
          console.log(this.menuType)
        }
        // else if(localStorage.getItem('user')){
        //   let userStore = localStorage.getItem('user');
        //   let userData = userStore && JSON.parse(userStore);
        //   this.userName= userData.name;
        //   this.menuType='user';
        //   this.product.getCartList(userData.id);
        // }
         else {
          this.menuType = 'default';
        }
      }
    });
  }
  logout():void{
    localStorage.removeItem('admin')
    this.route.navigate(['/'])
  }
}


