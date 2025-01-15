package kr.hhplus.be.server.application.facade;

import kr.hhplus.be.server.application.service.QueueTokenService;
import kr.hhplus.be.server.application.service.ReservationService;
import kr.hhplus.be.server.application.service.SeatService;
import kr.hhplus.be.server.domain.entity.QueueToken;
import kr.hhplus.be.server.domain.entity.Seat;
import kr.hhplus.be.server.domain.enums.QueueTokenStatus;
import kr.hhplus.be.server.presentation.dto.ReservationResponse;
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
  public ReservationResponse reserveSeat(long seatId, String uuid, Long userId,
                                         LocalDateTime now) {

    Seat seat = seatService.reserveSeat(seatId);
    QueueToken token = queueTokenService.getToken(uuid, QueueTokenStatus.ACTIVE);
    queueTokenService.updateToken(List.of(token), now);
    reservationService.setReserve(seat.getId(), userId, now);
    return new ReservationResponse(true);
  }
}
