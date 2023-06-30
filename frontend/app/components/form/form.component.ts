import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { Order } from 'src/app/common/order';
import { Reservation } from 'src/app/common/reservation';
import { CourtService } from 'src/app/services/court.service';
import { FormService } from 'src/app/services/form.service';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent implements OnInit{

  formGroup !: FormGroup;

  courtNumber: number = 0;
  reservationTime: string = "";

  constructor(private formBuilder: FormBuilder, 
    private courtService: CourtService,
    private formService: FormService,
    private router: Router) {}

  ngOnInit(): void {
    
    this.formGroup = this.formBuilder.group({
      user: this.formBuilder.group({
        firstName: [''],
        lastName: [''],
        email: [''],
        phoneNumber: ['']
      })
    });

  }

  onSubmit() {

    if(this.formGroup.invalid) {
    this.formGroup.markAllAsTouched();
    return;
    }

    let order = new Order(this.courtNumber, this.reservationTime);

    let reservation = new Reservation(order, this.formGroup.controls['user'].value);

    this.formService.placeOrder(reservation).subscribe(
      {
        next: response => {
          alert(`Zarezerwowano!`);
          this.resetCart();
        },
        error: err => {
          alert(`Wystąpił błąd: ${err.message}`);
        }
      }
    );
 
  }
  resetCart() {
    this.courtService.courtNumber = 0;
    this.courtService.reservationTime = "";

    this.formGroup.reset();

    this.router.navigateByUrl("/courts");
  }

}
