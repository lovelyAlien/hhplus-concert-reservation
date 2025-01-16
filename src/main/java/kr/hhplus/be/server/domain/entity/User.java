package kr.hhplus.be.server.domain.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "user")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id; // 유저 ID (기본 키)

  @Column(name = "name", nullable = false)
  private String name; // 사용자 이름

}

