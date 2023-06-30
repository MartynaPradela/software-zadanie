package com.example.tennis.repository;

import com.example.tennis.entity.Court;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
@CrossOrigin("http://localhost:4200")
public interface CourtRepository extends JpaRepository<Court, Long> {

}
