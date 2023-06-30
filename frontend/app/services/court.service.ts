import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, map } from 'rxjs';
import { Court } from '../common/court';

@Injectable({
  providedIn: 'root'
})
export class CourtService {

  private courtsUrl = 'http://localhost:8080/api/courts';

  courtNumber: number = 0;
  reservationTime: string = "";

  constructor(private http: HttpClient) { }

  public findAll(): Observable<Court[]> {
    return this.http.get<GetResponse>(this.courtsUrl).pipe(map(response => response._embedded.courts));
  }
}

interface GetResponse {
  _embedded: {
    courts: Court[];
  }
}
