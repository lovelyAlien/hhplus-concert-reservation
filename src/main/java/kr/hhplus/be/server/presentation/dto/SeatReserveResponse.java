package kr.hhplus.be.server.presentation.dto;

public class SeatReserveResponse {
  private String status;   // ex) "SUCCESS", "FAIL"
  private String message;

  public SeatReserveResponse(String status, String message) {
    this.status = status;
    this.message = message;
  }
  public String getStatus() { return status; }
  public String getMessage() { return message; }
}
