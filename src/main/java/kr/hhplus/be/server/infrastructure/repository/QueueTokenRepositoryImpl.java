package kr.hhplus.be.server.infrastructure.repository;

import kr.hhplus.be.server.domain.entity.QueueToken;
import kr.hhplus.be.server.domain.enums.QueueTokenStatus;
import kr.hhplus.be.server.domain.repository.QueueTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class QueueTokenRepositoryImpl implements QueueTokenRepository {
  private final QueueTokenJpaRepository queueTokenJpaRepository;

  @Override
  public QueueToken save(QueueToken tokens) {
    return queueTokenJpaRepository.save(tokens);
  }

  @Override
  public List<QueueToken> saveAll(List<QueueToken> tokens) {
    return queueTokenJpaRepository.saveAll(tokens);
  }

  @Override
  public Optional<QueueToken> findByUuidAndStatus(String uuid, QueueTokenStatus status) {
    return queueTokenJpaRepository.findByUuidAndStatus(uuid, status);
  }

  @Override
  public QueueToken findByUuid(String uuid) {
    return queueTokenJpaRepository.findByUuid(uuid);
  }
}
