package kr.hhplus.be.server.presentation.dto;

public class PaymentResponse {
  private String status;   // ex) "SUCCESS", "FAIL"
  private String message;

  public PaymentResponse(String status, String message) {
    this.status = status;
    this.message = message;
  }
  public String getStatus() { return status; }
  public String getMessage() { return message; }
}
