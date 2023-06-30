package com.example.tennis.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="court")
@Data
public class Court {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "court_nr")
    private int courtNumber;

    @Column(name = "free_time")
    private String timeReservation;


}
