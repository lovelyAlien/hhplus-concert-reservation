package kr.hhplus.be.server.infrastructure.repository;

import kr.hhplus.be.server.domain.entity.Seat;
import kr.hhplus.be.server.domain.enums.SeatStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SeatJpaRepository extends JpaRepository<Seat, Long> {
  List<Seat> findByScheduleIdAndStatus(Long scheduleId, SeatStatus status);
  Optional<Seat> findByIdAndStatus(long seatId, SeatStatus status);
}
