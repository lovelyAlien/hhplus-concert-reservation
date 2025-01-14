package kr.hhplus.be.server.domain.repository;

import kr.hhplus.be.server.domain.entity.ConcertSchedule;

import java.time.LocalDateTime;
import java.util.List;

public interface ConcertScheduleRepository {
  public List<ConcertSchedule> findByConcertIdAndStartAtAfter(Long concertId, LocalDateTime localDateTime);
}
