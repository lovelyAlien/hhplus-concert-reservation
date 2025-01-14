package kr.hhplus.be.server.domain.repository;

import kr.hhplus.be.server.domain.entity.Seat;
import kr.hhplus.be.server.domain.enums.SeatStatus;

import java.util.List;

public interface SeatRepository {
  List<Seat> findByScheduleIdAndStatus(Long scheduleId, SeatStatus status);
}
