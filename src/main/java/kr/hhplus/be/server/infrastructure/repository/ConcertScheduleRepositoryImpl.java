package kr.hhplus.be.server.infrastructure.repository;

import kr.hhplus.be.server.domain.entity.ConcertSchedule;
import kr.hhplus.be.server.domain.repository.ConcertScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ConcertScheduleRepositoryImpl implements ConcertScheduleRepository {
  private final ConcertScheduleJpaRepository concertScheduleJpaRepository;

  @Override
  public List<ConcertSchedule> findByConcertIdAndStartAtAfter(Long concertId, LocalDateTime localDateTime) {
    return concertScheduleJpaRepository.findByConcertIdAndStartAtAfter(concertId, localDateTime);
  }
}
