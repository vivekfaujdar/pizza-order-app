import { inject } from '@angular/core';
import { CanActivateFn } from '@angular/router';
import { AdminService } from './services/admin.service';

export const authGuard: CanActivateFn = (route, state) => {
const adminService=inject(AdminService)
  if(localStorage.getItem('admin')){
    return true;
  }

  return adminService.isAdminLoggedIn;
};
