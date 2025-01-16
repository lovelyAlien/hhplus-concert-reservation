package kr.hhplus.be.server.domain.dto;

import kr.hhplus.be.server.domain.entity.Point;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class PointResult {
  final private Long userId; // 사용자 ID
  final private BigDecimal balance; // 포인트 수

  public PointResult(Long userId, BigDecimal balance) {
    this.userId = userId;
    this.balance = balance;
  }

  // 정적 팩토리 메소드
  public static PointResult fromEntity(Point point) {
    return new PointResult(point.getUserId(), point.getBalance());
  }
}
