package kr.hhplus.be.server.infrastructure.repository;

import kr.hhplus.be.server.domain.entity.Point;
import kr.hhplus.be.server.domain.repository.PointRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PointRepositoryImpl implements PointRepository {
  private final PointJpaRepository pointJpaRepository;

  @Override
  public Point findByUserId(long userId) {
    return pointJpaRepository.findByUserId(userId);
  }

  @Override
  public void save(Point point) {
    pointJpaRepository.save(point);
  }
}
