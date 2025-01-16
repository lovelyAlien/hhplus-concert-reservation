package kr.hhplus.be.server.application.facade;

import kr.hhplus.be.server.application.service.QueueTokenService;
import kr.hhplus.be.server.application.service.ReservationService;
import kr.hhplus.be.server.application.service.SeatService;
import kr.hhplus.be.server.domain.entity.QueueToken;
import kr.hhplus.be.server.domain.entity.Seat;
import kr.hhplus.be.server.domain.enums.QueueTokenStatus;
import kr.hhplus.be.server.presentation.dto.SeatReserveResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ReservationFacade {

  private final QueueTokenService queueTokenService;
  private final SeatService seatService;
  private final ReservationService reservationService;

  @Transactional
  public SeatReserveResponse reserveSeat(long seatId, long userId, String uuid,
                                         LocalDateTime now) {

    QueueToken token = queueTokenService.getToken(uuid, QueueTokenStatus.ACTIVE);
    Seat seat = seatService.reserveSeat(seatId);
    queueTokenService.updateToken(List.of(token), now);
    reservationService.setReserve(seat.getId(), userId, now);
    return new SeatReserveResponse(true);
  }
}
