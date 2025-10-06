import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './Layout/home/home.component';
import { ListEventsComponent } from './Layout/list-events/list-events.component';
import { NotFoundComponent } from './Layout/not-found/not-found.component';

const routes: Routes = [
  { path: '', redirectTo: '/Acc', pathMatch: 'full' },
  { path: 'Acc', component: HomeComponent },
  {path: 'events', component:ListEventsComponent},
  {path:'**', component:NotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
