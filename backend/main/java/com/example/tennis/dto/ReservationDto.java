package com.example.tennis.dto;

import com.example.tennis.entity.Court;
import com.example.tennis.entity.User;
import lombok.Data;

@Data
public class ReservationDto {

    private Long id;
    private User user;
    private Court court;

    public static ReservationBuilder builder() {
        return new ReservationBuilder();
    }

    public static class ReservationBuilder {

        private Long id;
        private User user;
        private Court court;

        public ReservationBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public ReservationBuilder withUser(User user) {
            this.user = user;
            return this;
        }

        public ReservationBuilder withCourt(Court court) {
            this.court = court;
            return this;
        }

        public ReservationDto build() {
            ReservationDto reservationDto = new ReservationDto();
            reservationDto.setId(this.id);
            reservationDto.setUser(this.user);
            reservationDto.setCourt(this.court);
            return reservationDto;
        }
    }
}
