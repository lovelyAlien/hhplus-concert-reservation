package kr.hhplus.be.server.application.facade;

import kr.hhplus.be.server.application.service.SeatService;
import kr.hhplus.be.server.domain.entity.Seat;
import kr.hhplus.be.server.domain.enums.SeatStatus;
import kr.hhplus.be.server.presentation.dto.ConcertDateResponse;
import kr.hhplus.be.server.application.service.ConcertScheduleService;
import kr.hhplus.be.server.presentation.dto.ConcertSeatResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ConcertFacade {

  private final ConcertScheduleService concertScheduleService;
  private final SeatService seatService;

  public List<ConcertDateResponse> findAvailableDates(Long concertId, LocalDateTime now) {
    return concertScheduleService.findDates(concertId, now).stream()
      .map(schedule -> new ConcertDateResponse(
        schedule.getId(), // scheduleId
        schedule.getStartAt(),
        schedule.getStatus() // performanceDateAt
      )).collect(Collectors.toList());
  }

  public List<ConcertSeatResponse> findAvailableSeats(Long scheduleId, SeatStatus status) {
    return seatService.findSeats(scheduleId, status).stream()
      .map(seat -> new ConcertSeatResponse(seat.getSeatNo(), seat.getStatus()))
      .collect(Collectors.toList());
  }
}
