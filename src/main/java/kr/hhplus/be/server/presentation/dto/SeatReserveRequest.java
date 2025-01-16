package kr.hhplus.be.server.presentation.dto;

public class SeatReserveRequest {

  private Long userId;
  private Long seatId;

  public SeatReserveRequest(Long userId, Long seatId) {
    this.userId = userId;
    this.seatId = seatId;
  }

  public Long getUserId() { return userId; };
  public Long getSeatId() { return seatId;}


}
