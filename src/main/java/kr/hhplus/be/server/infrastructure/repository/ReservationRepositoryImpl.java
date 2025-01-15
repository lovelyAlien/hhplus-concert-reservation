package kr.hhplus.be.server.infrastructure.repository;

import kr.hhplus.be.server.domain.entity.Reservation;
import kr.hhplus.be.server.domain.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ReservationRepositoryImpl implements ReservationRepository {
  private final ReservationJpaRepository reservationJpaRepository;

  @Override
  public Reservation save(Reservation reservation) {
    return reservationJpaRepository.save(reservation);
  }
}
