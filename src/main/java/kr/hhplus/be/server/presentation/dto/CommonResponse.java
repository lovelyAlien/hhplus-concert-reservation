package kr.hhplus.be.server.presentation.dto;

public class CommonResponse {
  private String status;   // "SUCCESS"/"FAIL"
  private String message;

  public CommonResponse(String status, String message) {
    this.status = status;
    this.message = message;
  }
  public String getStatus() { return status; }
  public String getMessage() { return message; }
}
