import { Component, OnInit } from '@angular/core';
import { Court } from 'src/app/common/court';
import { CourtService } from 'src/app/services/court.service';

@Component({
  selector: 'app-court',
  templateUrl: './court.component.html',
  styleUrls: ['./court.component.css']
})
export class CourtComponent implements OnInit{

  courts : Court[] = [];
  courtNumber: number = 0;
  courtTime: string = "";

  constructor(private courtService: CourtService) {}

  ngOnInit(): void {
    this.courtService.findAll().subscribe(data => {
      this.courts = data;
    });
  }

  addToCart(theCourt: Court) {
    this.courtNumber = theCourt.courtNumber;
    this.courtTime = theCourt.timeReservation;
  }


}
