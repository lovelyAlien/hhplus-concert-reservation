package kr.hhplus.be.server.application.service;

import kr.hhplus.be.server.domain.entity.Reservation;
import kr.hhplus.be.server.domain.entity.Seat;
import kr.hhplus.be.server.domain.enums.ReservationStatus;
import kr.hhplus.be.server.domain.enums.SeatStatus;
import kr.hhplus.be.server.domain.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReservationService {
  private final ReservationRepository reservationRepository;

  public void setReserve(long  seatId, Long userId, LocalDateTime now) {
    Reservation reservation = Reservation.create(
      userId, seatId, ReservationStatus.IN_PROGRESS, now, now.plusMinutes(5)
    );
    reservationRepository.save(reservation);
  }

  public void updateStatus(long reservationId, ReservationStatus status) {
    Optional<Reservation> opt = reservationRepository.findById(reservationId);
    Reservation reservation = opt.orElseThrow(() -> new RuntimeException("Reservation not found"));
    reservation.setStatus(status);
    reservationRepository.save(reservation);
  }

  public boolean isReservationExpired(long reservationId) {
    // 예약 정보 조회
    Reservation reservation = reservationRepository.findById(reservationId)
      .orElseThrow(() -> new RuntimeException("Reservation not found for ID: " + reservationId));

    // 만료 여부 반환
    return reservation.getExpireAt().isBefore(LocalDateTime.now());
  }
}
