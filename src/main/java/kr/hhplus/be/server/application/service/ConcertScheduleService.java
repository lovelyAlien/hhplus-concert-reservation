package kr.hhplus.be.server.application.service;

import kr.hhplus.be.server.presentation.dto.ConcertDateResponse;
import kr.hhplus.be.server.domain.entity.ConcertSchedule;
import kr.hhplus.be.server.domain.repository.ConcertScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ConcertScheduleService {
  private final ConcertScheduleRepository concertScheduleRepository;
  // 예약 가능 날짜 조회
  public List<ConcertDateResponse> findDates(Long concertId, LocalDateTime now) {
    List<ConcertSchedule> schedules = concertScheduleRepository.findByConcertIdAndStartAtAfter(
      concertId, now
    );

    return schedules.stream()
      .map(schedule -> new ConcertDateResponse(
        schedule.getId(), // scheduleId
        schedule.getStartAt(),
        schedule.getStatus() // performanceDateAt
      )).collect(Collectors.toList());
  }
}
