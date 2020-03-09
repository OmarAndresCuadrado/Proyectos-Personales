import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CriminalComponent } from './pages/criminal/criminal.component';
import { CriminalFormComponent } from './pages/criminal-form/criminal-form.component';
import { PeopleComponent } from './pages/people/people.component';
import { PeopleFormComponent } from './pages/people-form/people-form.component';


const routes: Routes = [

  { path: '', redirectTo: '/criminal', pathMatch: 'full' },
{ path: 'criminal', component: CriminalComponent },
{ path: 'criminalForm', component: CriminalFormComponent },
{ path: 'people', component: PeopleComponent },
{ path: 'peopleForm', component: PeopleFormComponent },

];




@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
