package kr.hhplus.be.server.infrastructure.repository;

import kr.hhplus.be.server.domain.entity.QueueToken;
import kr.hhplus.be.server.domain.enums.QueueTokenStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface QueueTokenJpaRepository extends JpaRepository<QueueToken, Long> {
  @Query("SELECT q FROM QueueToken q WHERE q.userId = :userId AND q.concertId = :concertId AND q.status <> :status")
  List<QueueToken> findNonExpiredTokens(@Param("userId") Long userId, @Param("concertId") Long concertId, @Param("status") QueueTokenStatus status);

  Optional<QueueToken> findByUuidAndStatus(String uuid, QueueTokenStatus status);
}
