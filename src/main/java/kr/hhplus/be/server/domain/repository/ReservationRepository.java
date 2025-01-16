package kr.hhplus.be.server.domain.repository;

import kr.hhplus.be.server.domain.entity.Reservation;

import java.util.Optional;

public interface ReservationRepository {
  Reservation save(Reservation reservation);
  Optional<Reservation> findById(long reservationId);
}
