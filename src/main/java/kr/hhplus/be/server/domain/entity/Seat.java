package kr.hhplus.be.server.domain.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "seat")
public class Seat {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "schedule_id", nullable = false)
  private ConcertSchedule concertSchedule;

  @Enumerated(EnumType.STRING)
  private Status status;

  private BigDecimal price;

  // Getters and Setters

  public enum Status {
    AVAILABLE,
    RESERVED,
    SOLD
  }
}
