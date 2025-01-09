package kr.hhplus.be.server.presentation.dto;

public class PointBalanceResponse {
  private String userId;
  private int balance;

  public PointBalanceResponse(String userId, int balance) {
    this.userId = userId;
    this.balance = balance;
  }
  public String getUserId() { return userId; }
  public int getBalance() { return balance; }
}
