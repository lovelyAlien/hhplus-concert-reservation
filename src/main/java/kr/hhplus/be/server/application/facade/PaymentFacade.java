package kr.hhplus.be.server.application.facade;

import kr.hhplus.be.server.application.service.*;
import kr.hhplus.be.server.domain.dto.PointResult;
import kr.hhplus.be.server.domain.entity.QueueToken;
import kr.hhplus.be.server.domain.enums.PaymentStatus;
import kr.hhplus.be.server.domain.enums.QueueTokenStatus;
import kr.hhplus.be.server.domain.enums.ReservationStatus;
import kr.hhplus.be.server.domain.enums.SeatStatus;
import kr.hhplus.be.server.presentation.dto.PaymentResponse;
import kr.hhplus.be.server.presentation.dto.PointResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class PaymentFacade {

  private final QueueTokenService queueTokenService;
  private final PaymentService paymentService;
  private final PointService pointService;
  private final SeatService seatService;
  private final ReservationService reservationService;

  @Transactional
  public PaymentResponse processPayment(
    long reservationId,long seatId, long userId,
    String uuid, BigDecimal amount, LocalDateTime now) {

    // 1. 토큰 조회
    QueueToken token = queueTokenService.getToken(uuid, QueueTokenStatus.ACTIVE);
    // 2. 예약 만료 및 상태 업데이트
    if (handleExpiredReservation(reservationId, seatId)) {
      return new PaymentResponse("FAIL", "Reservation is expired and cannot proceed with payment.");
    }
    // 3. 포인트 차감
    pointService.pay(userId, amount);
    // 4. 예약 정보 업데이트
    reservationService.updateStatus(seatId, ReservationStatus.COMPLETED);
    // 5. 결제
    paymentService.addPaymentRecord(reservationId, userId, amount,
      now, PaymentStatus.PAID);
    // 6. 토큰 만료
    queueTokenService.expireToken(List.of(token));

    return new PaymentResponse("SUCCESS", "Payment processed successfully.");
  }

  public PointResponse getPoint(Long userId) {
    PointResult point = pointService.getPoint(userId);
    return new PointResponse(point.getBalance());
  }

  @Transactional
  public PointResponse chargePoint(Long userId, BigDecimal amount) {
    BigDecimal balance = pointService.chargePoint(userId, amount);
    return new PointResponse(balance);
  }

  private boolean handleExpiredReservation(long reservationId, long seatId) {
    boolean isExpired = reservationService.isReservationExpired(reservationId);
    if (isExpired) {
      reservationService.updateStatus(reservationId, ReservationStatus.EXPIRED);
      seatService.updateStatus(seatId, SeatStatus.AVAILABLE);
    }
    return isExpired;
  }
}
