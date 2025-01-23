package kr.hhplus.be.server.infrastructure.repository;

import kr.hhplus.be.server.domain.entity.QueueToken;
import kr.hhplus.be.server.domain.enums.QueueTokenStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface QueueTokenJpaRepository extends JpaRepository<QueueToken, Long> {

  Optional<QueueToken> findByUuidAndStatus(String uuid, QueueTokenStatus status);
  QueueToken findByUuid(String uuid);
}
