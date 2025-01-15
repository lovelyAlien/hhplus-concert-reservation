package kr.hhplus.be.server.domain.entity;

import jakarta.persistence.*;
import kr.hhplus.be.server.domain.enums.SeatStatus;
import lombok.Getter;

import java.math.BigDecimal;

@Entity
@Getter
@Table(name = "seat")
public class Seat {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "seat_no", nullable = false)
  private String seatNo; // 좌석 번호

  @Column(name = "schedule_id", nullable = false)
  private Long scheduleId;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private SeatStatus status; // 좌석 상태

  private BigDecimal price;

  // Getters and Setters
  public void setStatus(SeatStatus status) {
    this.status = status;
  }
}
