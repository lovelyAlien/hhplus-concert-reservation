package kr.hhplus.be.server.presentation.dto;

import java.math.BigDecimal;

public class PaymentRequest {
  private Long userId;
  private Long reservationId;
  private Long seatId;
  private BigDecimal amount;

  public Long getUserId() { return userId; }
  public Long getReservationId() { return reservationId; }
  public Long getSeatId() { return seatId; }
  public BigDecimal getAmount() { return amount; }
}
