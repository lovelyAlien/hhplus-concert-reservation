package kr.hhplus.be.server.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_point")
@Builder
public class Point {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id; // 예약 ID (기본 키)

  @Column(name = "user_id", nullable = false)
  private Long userId; // 사용자 ID

  @Column(name = "balance", nullable = false)
  private BigDecimal balance; // 포인트

  public void decrease(BigDecimal amount) {
    if (amount == null || amount.compareTo(BigDecimal.ZERO) < 0) {
      throw new IllegalArgumentException("감소할 포인트는 0보다 커야 합니다.");
    }
    if (this.balance.compareTo(amount) < 0) {
      throw new IllegalArgumentException("잘못된 포인트 값 입니다.");
    }
    this.balance = this.balance.subtract(amount);
  }

  public void increase(BigDecimal amount) {
    if (amount == null || amount.compareTo(BigDecimal.ZERO) < 0) {
      throw new IllegalArgumentException("충전할 포인트는 0보다 커야 합니다.");
    }
    this.balance = this.balance.add(amount);
  }
}
