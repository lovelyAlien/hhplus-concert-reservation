package kr.hhplus.be.server.infrastructure.repository;

import kr.hhplus.be.server.domain.entity.Point;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PointJpaRepository extends JpaRepository<Point, Long> {
  Point findByUserId(long userId);
}
