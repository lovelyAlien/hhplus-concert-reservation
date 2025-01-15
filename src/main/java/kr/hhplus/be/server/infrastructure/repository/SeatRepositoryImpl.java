package kr.hhplus.be.server.infrastructure.repository;

import kr.hhplus.be.server.domain.entity.QueueToken;
import kr.hhplus.be.server.domain.entity.Seat;
import kr.hhplus.be.server.domain.enums.SeatStatus;
import kr.hhplus.be.server.domain.repository.SeatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class SeatRepositoryImpl implements SeatRepository {
  private final SeatJpaRepository seatJpaRepository;

  @Override
  public List<Seat> findByScheduleIdAndStatus(Long scheduleId, SeatStatus status) {
    return seatJpaRepository.findByScheduleIdAndStatus(scheduleId, SeatStatus.AVAILABLE);
  }

  @Override
  public Optional<Seat> findByIdAndStatus(long seatId, SeatStatus status) {
    return seatJpaRepository.findByIdAndStatus(seatId, status);
  }

  @Override
  public Seat save(Seat seat) {
    return seatJpaRepository.save(seat);
  }
}
