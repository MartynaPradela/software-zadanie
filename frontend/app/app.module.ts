import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { CourtComponent } from './components/court/court.component';
import { HttpClientModule } from '@angular/common/http';
import { CourtService } from './services/court.service';
import { FormComponent } from './components/form/form.component';
import { RouterModule, Routes } from '@angular/router';
import { ReactiveFormsModule } from '@angular/forms';
import { ReservationComponent } from './components/reservation/reservation.component';

const routes: Routes = [
  {path: 'form', component: FormComponent},
  {path: 'reservation', component: ReservationComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    CourtComponent,
    FormComponent,
    ReservationComponent
  ],
  imports: [
    RouterModule.forRoot(routes),
    BrowserModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [CourtService],
  bootstrap: [AppComponent]
})
export class AppModule { }
