package kr.hhplus.be.server.domain.repository;

import kr.hhplus.be.server.domain.entity.QueueToken;
import kr.hhplus.be.server.domain.enums.QueueTokenStatus;

import java.util.List;
import java.util.Optional;

public interface QueueTokenRepository {

  // WAIT 또는 ACTIVE 상태의 토큰 조회
  List<QueueToken> findNonExpiredTokens(Long userId, Long concertId, QueueTokenStatus status);
  QueueToken save(QueueToken queueToken);
  List<QueueToken> saveAll(List<QueueToken> tokens);
  Optional<QueueToken> findByUuidAndStatus(String uuid, QueueTokenStatus status);

}
