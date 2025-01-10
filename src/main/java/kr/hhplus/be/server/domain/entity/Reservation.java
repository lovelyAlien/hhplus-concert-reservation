package kr.hhplus.be.server.domain.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "reservation")
public class Reservation {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  @ManyToOne
  @JoinColumn(name = "seat_id", nullable = false)
  private Seat seat;

  @Enumerated(EnumType.STRING)
  private Status status;

  // Getters and Setters

  public enum Status {
    PENDING,
    CONFIRMED,
    CANCELLED
  }
}
