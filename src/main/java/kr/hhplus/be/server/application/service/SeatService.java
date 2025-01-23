package kr.hhplus.be.server.application.service;

import kr.hhplus.be.server.domain.entity.Reservation;
import kr.hhplus.be.server.domain.entity.Seat;
import kr.hhplus.be.server.domain.enums.SeatStatus;
import kr.hhplus.be.server.domain.repository.SeatRepository;
import kr.hhplus.be.server.presentation.dto.ConcertSeatResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SeatService {

  private final SeatRepository seatRepository;

  public List<Seat> findSeats(Long scheduleId, SeatStatus status) {
    return seatRepository.findByScheduleIdAndStatus(scheduleId, status);
  }

  public Seat reserveSeat(long seatId) {
    Optional<Seat> opt = seatRepository.findByIdAndStatus(seatId, SeatStatus.AVAILABLE);
    Seat seat = opt.orElseThrow(() -> new RuntimeException("Seat not found"));
    seat.setStatus(SeatStatus.UNAVAILABLE);
    return seatRepository.save(seat);
  }

  public void updateStatus(long seatId, SeatStatus status) {
    Seat seat = seatRepository.findById(seatId)
      .orElseThrow(() -> new RuntimeException("Seat not found for ID: " + seatId));
    seat.setStatus(SeatStatus.AVAILABLE);
    seatRepository.save(seat);
  }
}
