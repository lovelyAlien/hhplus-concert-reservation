package kr.hhplus.be.server.domain.entity;

import jakarta.persistence.*;
import kr.hhplus.be.server.domain.enums.ConcertStatus;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "concert_schedule")
public class ConcertSchedule {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Long concertId;

  @Column(name = "status", nullable = false)
  @Enumerated(EnumType.STRING)
  private ConcertStatus status = ConcertStatus.AVAILABLE; // 기본값은 마감되지 않음

  @Column(name = "start_at")
  private LocalDateTime startAt;


  // Getters and Setters
}
