package kr.hhplus.be.server.domain.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "concert_schedule")
public class ConcertSchedule {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "concert_id", nullable = false)
  private Concert concert;

  @Column(name = "start_at")
  private LocalDateTime startAt;

  // Getters and Setters
}
