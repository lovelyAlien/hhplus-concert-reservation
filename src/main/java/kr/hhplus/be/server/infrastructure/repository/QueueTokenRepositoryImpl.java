package kr.hhplus.be.server.infrastructure.repository;

import kr.hhplus.be.server.domain.entity.QueueToken;
import kr.hhplus.be.server.domain.repository.QueueTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class QueueTokenRepositoryImpl implements QueueTokenRepository {
  private final QueueTokenJpaRepository queueTokenJpaRepository;

  @Override
  public List<QueueToken> findNonExpiredTokens(Long userId, Long concertId, QueueToken.Status status) {
    return queueTokenJpaRepository.findNonExpiredTokens(userId, concertId, status);
  }

  @Override
  public QueueToken save(QueueToken queueToken) {
    return queueTokenJpaRepository.save(queueToken);
  }

  @Override
  public List<QueueToken> saveAll(List<QueueToken> queueTokens) {
    return queueTokenJpaRepository.saveAll(queueTokens);
  }
}
