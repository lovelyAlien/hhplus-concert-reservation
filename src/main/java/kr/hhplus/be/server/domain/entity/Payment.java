package kr.hhplus.be.server.domain.entity;

import jakarta.persistence.*;
import kr.hhplus.be.server.domain.enums.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "payment")
public class Payment {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "user_id", nullable = false)
  private Long userId ;

  @Column(name = "reservation_id", nullable = false)
  private Long reservationId;

  private BigDecimal amount;

  @Column(name = "paid_at")
  private LocalDateTime paidAt;

  @Enumerated(EnumType.STRING)
  @Column(name = "status", nullable = false)
  private PaymentStatus status;

  // Getters and Setters
  public static Payment create(
    long reservationId, long userId, BigDecimal amount, LocalDateTime paidAt, PaymentStatus status) {
    return Payment.builder()
      .reservationId(reservationId)
      .userId(userId)
      .amount(amount)
      .paidAt(paidAt)
      .status(status)
      .build();
  }
}
