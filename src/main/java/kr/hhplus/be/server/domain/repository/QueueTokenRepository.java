package kr.hhplus.be.server.domain.repository;

import kr.hhplus.be.server.domain.entity.QueueToken;
import kr.hhplus.be.server.domain.enums.QueueTokenStatus;

import java.util.List;
import java.util.Optional;

public interface QueueTokenRepository {

  QueueToken save(QueueToken queueToken);
  List<QueueToken> saveAll(List<QueueToken> tokens);
  Optional<QueueToken> findByUuidAndStatus(String uuid, QueueTokenStatus status);

}
