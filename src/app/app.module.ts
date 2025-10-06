import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './Layout/home/home.component';
import { HeaderComponent } from './Layout/header/header.component';
import { FooterComponent } from './Layout/footer/footer.component';
import { NotFoundComponent } from './Layout/not-found/not-found.component';
import { CardComponent } from './card/card.component';
import { ListEventsComponent } from './Layout/list-events/list-events.component';
import { HighlightDirective } from './shared/directives/highlight.directive';
import { CustomDirectiveDirective } from './custom-directive.directive';
import { CommonModule } from '@angular/common';
import { ContainsPipe } from './shared/pipes/contains.pipe';


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    HeaderComponent,
    FooterComponent,
    NotFoundComponent,
    ListEventsComponent,
    HighlightDirective,
    CustomDirectiveDirective,
    ContainsPipe ,
   
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    CommonModule,
    FormsModule,
    CardComponent
  ],
  providers: [],
  exports: [HighlightDirective],
  bootstrap: [AppComponent]
})
export class AppModule { }
