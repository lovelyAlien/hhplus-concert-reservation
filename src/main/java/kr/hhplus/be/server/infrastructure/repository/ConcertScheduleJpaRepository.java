package kr.hhplus.be.server.infrastructure.repository;

import kr.hhplus.be.server.domain.entity.ConcertSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ConcertScheduleJpaRepository extends JpaRepository<ConcertSchedule, Long> {
  List<ConcertSchedule> findByConcertIdAndStartAtAfter(long concertId, LocalDateTime localDateTime);
}
