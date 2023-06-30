import { Injectable } from '@angular/core';
import { Observable, map } from 'rxjs';
import { Reservation } from '../common/reservation';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ReservationService {

  private reservationUrl = 'http://localhost:8080/api/reservations';

  constructor(private http: HttpClient) { }

  public findAll(): Observable<Reservation[]> {
    return this.http.get<GetResponse>(this.reservationUrl).pipe(map(response => response._embedded.reservations));
  }
}

interface GetResponse {
  _embedded: {
    reservations: Reservation[];
  }
}
