package kr.hhplus.be.server.presentation.dto;

public class SeatReserveRequest {

  private String userId;
  private String seatId;

  public SeatReserveRequest(String userId, String seatId) {
    this.userId = userId;
    this.seatId = seatId;
  }

  public String getUserId() { return userId; };
  public String getSeatId() { return seatId;}


}
