package kr.hhplus.be.server.infrastructure.repository;

import kr.hhplus.be.server.domain.entity.Reservation;
import kr.hhplus.be.server.domain.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ReservationRepositoryImpl implements ReservationRepository {
  private final ReservationJpaRepository reservationJpaRepository;

  @Override
  public Reservation save(Reservation reservation) {
    return reservationJpaRepository.save(reservation);
  }

  @Override
  public Optional<Reservation> findById(long reservationId) {
    return reservationJpaRepository.findById(reservationId);
  }
}
