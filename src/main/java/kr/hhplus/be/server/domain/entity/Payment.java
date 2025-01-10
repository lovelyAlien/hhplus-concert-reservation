package kr.hhplus.be.server.domain.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "payment")
public class Payment {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  @ManyToOne
  @JoinColumn(name = "reservation_id", nullable = false)
  private Reservation reservation;

  private BigDecimal amount;

  @Column(name = "paid_at")
  private LocalDateTime paidAt;

  @Enumerated(EnumType.STRING)
  private Status status;

  // Getters and Setters

  public enum Status {
    PENDING,
    PAID,
    FAILED
  }
}
