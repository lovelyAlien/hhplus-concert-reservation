package kr.hhplus.be.server.application.service;

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

  public List<ConcertSeatResponse> findSeats(Long scheduleId, SeatStatus status) {
    List<Seat> seats = seatRepository.findByScheduleIdAndStatus(scheduleId, status);
    return seats.stream()
      .map(seat -> new ConcertSeatResponse(seat.getSeatNo(), seat.getStatus()))
      .collect(Collectors.toList());
  }

  public Seat reserveSeat(long seatId) {
    Optional<Seat> opt = seatRepository.findByIdAndStatus(seatId, SeatStatus.AVAILABLE);
    Seat seat = opt.orElseThrow(() -> new RuntimeException("Seat not found"));
    seat.setStatus(SeatStatus.UNAVAILABLE);
    return seatRepository.save(seat);
  }
}
