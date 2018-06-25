import {RouterModule, Routes} from '@angular/router';

import {HomeComponent} from './home';
import {LoginComponent} from './shared/components/login';
import {RegisterComponent} from './shared/components/register/register.component';
import {AuthGuard} from './shared/guards/auth.guard';
import {WritePostComponent} from "./write-post/write-post.component";

const appRoutes: Routes = [
  {path: '', redirectTo: 'ui', pathMatch: 'full'},
  {path: 'ui', component: HomeComponent, canActivate: [AuthGuard]},
  {path: 'ui/new', component: WritePostComponent, canActivate: [AuthGuard]},
  {path: 'ui/login', component: LoginComponent},
  {path: 'ui/register', component: RegisterComponent},
  // otherwise redirect to home
  {path: '**', redirectTo: ''}
];

export const routing = RouterModule.forRoot(appRoutes);