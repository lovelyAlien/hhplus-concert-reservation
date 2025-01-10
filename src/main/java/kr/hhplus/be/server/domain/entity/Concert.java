package kr.hhplus.be.server.domain.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "concert")
public class Concert {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  @Column(columnDefinition = "TEXT")
  private String description;

  // Getters and Setters
}
