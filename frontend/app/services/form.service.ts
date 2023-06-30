import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Reservation } from '../common/reservation';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FormService {

  private resUrl = 'http://localhost:8080/api/reservation/form'

  constructor(private hhtpClient: HttpClient) { }

  placeOrder(reservation: Reservation): Observable<any> {
    return this.hhtpClient.post<Reservation>(this.resUrl, reservation);
  }
  
}
