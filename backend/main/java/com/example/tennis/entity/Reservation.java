package com.example.tennis.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="reservation")
@Data
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="user_id", referencedColumnName = "id")
    private User user;

    @OneToOne
    @JoinColumn(name = "court_id", referencedColumnName = "id")
    private Court court;


}
