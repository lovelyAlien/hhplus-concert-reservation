package kr.hhplus.be.server.domain.repository;

import kr.hhplus.be.server.domain.entity.Seat;
import kr.hhplus.be.server.domain.enums.SeatStatus;

import java.util.List;
import java.util.Optional;

public interface SeatRepository {
  Optional<Seat> findById(long seatId);
  List<Seat> findByScheduleIdAndStatus(Long scheduleId, SeatStatus status);
  Optional<Seat> findByIdAndStatus(long seatId, SeatStatus status);
  Seat save(Seat seat);
}
