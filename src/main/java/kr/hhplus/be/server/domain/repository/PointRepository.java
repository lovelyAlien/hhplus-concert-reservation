package kr.hhplus.be.server.domain.repository;

import kr.hhplus.be.server.domain.entity.Point;

public interface PointRepository {
  Point findByUserId(long userId);
  void save(Point point);
}
