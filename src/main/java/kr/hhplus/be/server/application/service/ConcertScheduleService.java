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
  public List<ConcertSchedule> findDates(Long concertId, LocalDateTime now) {
    return concertScheduleRepository.findByConcertIdAndStartAtAfter(
      concertId, now
    );
  }
}
