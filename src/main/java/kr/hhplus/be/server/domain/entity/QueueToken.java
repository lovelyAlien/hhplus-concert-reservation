package kr.hhplus.be.server.domain.entity;

import jakarta.persistence.*;
import kr.hhplus.be.server.domain.enums.QueueTokenStatus;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Entity
@Table(name = "queue_token")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QueueToken {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "uuid", nullable = false, unique = true, updatable = false)
  private String uuid; // UUID 필드 추가

  private Long userId;

  private Long concertId;

  @Enumerated(EnumType.STRING)
  private QueueTokenStatus status;

  @Column(name = "created_at")
  private LocalDateTime createdAt;

  @Column(name = "expire_at")
  private LocalDateTime expireAt;

  // Getters and Setters

  // 상태 변경 메서드
  public void expire() {
    if (this.status == QueueTokenStatus.EXPIRED) {
      throw new IllegalStateException("Token is already expired.");
    }
    this.status = QueueTokenStatus.EXPIRED;
    this.expireAt = LocalDateTime.now(); // 만료 시점 업데이트
  }

  public void activate() {
    this.status = QueueTokenStatus.ACTIVE;
  }

  public void setExpiration(LocalDateTime expireAt) {
    this.expireAt = expireAt;
  }

  public static QueueToken create(Long userId, Long concertId, LocalDateTime now, LocalDateTime expireAt) {
    return QueueToken.builder()
      .uuid(UUID.randomUUID().toString())
      .userId(userId)
      .concertId(concertId)
      .status(QueueTokenStatus.WAIT)
      .createdAt(now)
      .expireAt(expireAt)
      .build();
  }
}
