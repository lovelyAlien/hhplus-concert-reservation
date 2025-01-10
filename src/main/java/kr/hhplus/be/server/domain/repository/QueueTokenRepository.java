package kr.hhplus.be.server.domain.repository;

import kr.hhplus.be.server.domain.entity.QueueToken;

import java.util.List;

public interface QueueTokenRepository {

  // WAIT 또는 ACTIVE 상태의 토큰 조회
  List<QueueToken> findNonExpiredTokens(Long userId, Long concertId, QueueToken.Status status);
  QueueToken save(QueueToken queueToken);
  List<QueueToken> saveAll(List<QueueToken> queueTokens);

}
