package kr.hhplus.be.server.application.service;

import kr.hhplus.be.server.domain.entity.Reservation;
import kr.hhplus.be.server.domain.enums.ReservationStatus;
import kr.hhplus.be.server.domain.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ReservationService {
  private final ReservationRepository reservationRepository;

  public void setReserve(long  seatId, Long userId, LocalDateTime now) {
    Reservation reservation = Reservation.createNewReservation(
      userId, seatId, ReservationStatus.IN_PROGRESS, now, now.plusMinutes(5)
    );
    reservationRepository.save(reservation);
  }
}
