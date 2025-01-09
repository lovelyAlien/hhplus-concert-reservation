package kr.hhplus.be.server.presentation.dto;

public class PaymentRequest {
  // 결제
  // userId, reservationId;
  //
  private String userId;
  private String reservationId;
  private String date;   // "2025-01-10" 등
  private String seatId;

  public String getUserId() { return userId; }
  public String getReservationId() { return reservationId; }
  public String getDate() { return date; }
  public String getSeatId() { return seatId; }
}
