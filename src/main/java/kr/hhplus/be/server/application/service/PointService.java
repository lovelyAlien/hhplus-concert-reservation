package kr.hhplus.be.server.application.service;

import kr.hhplus.be.server.domain.dto.PointResult;
import kr.hhplus.be.server.domain.entity.Point;
import kr.hhplus.be.server.domain.entity.User;
import kr.hhplus.be.server.domain.repository.PointRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class PointService {

  private final PointRepository pointRepository;

  @Transactional
  public void pay(long userId, BigDecimal amount) {
    Point point = pointRepository.findByUserId(userId);
    point.decrease(amount);
    pointRepository.save(point);
  }

  public PointResult getPoint(Long userId) {
    Point point = pointRepository.findByUserId(userId);
    return PointResult.fromEntity(point);
  }

  @Transactional
  public BigDecimal chargePoint(Long userId, BigDecimal amount) {
    Point point = pointRepository.findByUserId(userId);
    point.increase(amount);
    pointRepository.save(point);
    return point.getBalance();
  }
}
