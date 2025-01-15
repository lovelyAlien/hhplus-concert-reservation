package kr.hhplus.be.server.domain.repository;

import kr.hhplus.be.server.domain.entity.Reservation;

public interface ReservationRepository {
  Reservation save(Reservation reservation);
}
