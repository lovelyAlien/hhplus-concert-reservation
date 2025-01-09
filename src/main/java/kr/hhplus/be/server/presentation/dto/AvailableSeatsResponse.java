package kr.hhplus.be.server.presentation.dto;

public class AvailableSeatsResponse {
  private String date;
  private String[] availableSeats;

  public AvailableSeatsResponse(String date, String[] availableSeats) {
    this.date = date;
    this.availableSeats = availableSeats;
  }
  public String getDate() { return date; }
  public String[] getAvailableSeats() { return availableSeats; }
}
