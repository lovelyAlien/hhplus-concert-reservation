package kr.hhplus.be.server.domain.entity;

import jakarta.persistence.*;
import kr.hhplus.be.server.domain.enums.ReservationStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "reservation")
public class Reservation {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "user_id", nullable = false)
  private Long userId;

  @Column(name = "seat_id", nullable = false)
  private Long seatId;

  @Enumerated(EnumType.STRING)
  @Column(name = "status", nullable = false)
  private ReservationStatus status;

  @Column(name = "created_at")
  private LocalDateTime createdAt;

  @Column(name = "expired_at")
  private LocalDateTime expiredAt;

  // Getters and Setters
  public static Reservation createNewReservation(Long userId, Long seatId, ReservationStatus status,
                                                 LocalDateTime now, LocalDateTime expiredAt) {
    return Reservation.builder()
      .userId(userId)
      .seatId(seatId)
      .status(status)
      .createdAt(now)
      .expiredAt(expiredAt)
      .build();
  }
}
