package kr.hhplus.be.server.infrastructure.repository;

import kr.hhplus.be.server.domain.entity.QueueToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QueueTokenJpaRepository extends JpaRepository<QueueToken, Long> {
  @Query("SELECT q FROM QueueToken q WHERE q.userId = :userId AND q.concertId = :concertId AND q.status <> :status")
  List<QueueToken> findNonExpiredTokens(@Param("userId") Long userId, @Param("concertId") Long concertId, @Param("status") QueueToken.Status status);
}
