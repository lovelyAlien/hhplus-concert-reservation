package kr.hhplus.be.server.domain.entity;

import jakarta.persistence.*;
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
  private Status status;

  @Column(name = "created_at")
  private LocalDateTime createdAt;

  @Column(name = "expired_at")
  private LocalDateTime expiredAt;

  // Getters and Setters

  public enum Status {
    WAIT,
    ACTIVE,
    EXPIRED
  }

  // 상태 변경 메서드
  public void expire() {
    if (this.status == Status.EXPIRED) {
      throw new IllegalStateException("Token is already expired.");
    }
    this.status = Status.EXPIRED;
    this.expiredAt = LocalDateTime.now(); // 만료 시점 업데이트
  }

  public static QueueToken createNewToken(Long userId, Long concertId, LocalDateTime expiredAt) {
    return QueueToken.builder()
      .uuid(UUID.randomUUID().toString())
      .userId(userId)
      .concertId(concertId)
      .status(Status.WAIT)
      .createdAt(LocalDateTime.now())
      .expiredAt(expiredAt)
      .build();
  }
}
