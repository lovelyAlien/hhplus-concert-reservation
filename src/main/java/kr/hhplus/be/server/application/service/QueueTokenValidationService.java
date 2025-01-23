package kr.hhplus.be.server.application.service;

import kr.hhplus.be.server.common.error.TokenErrorType;
import kr.hhplus.be.server.common.error.TokenNotFoundException;
import kr.hhplus.be.server.domain.entity.QueueToken;
import kr.hhplus.be.server.domain.repository.QueueTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class QueueTokenValidationService {

  private final QueueTokenRepository queueTokenRepository;

  public boolean validateQueueTokenProcessing(final String uuid, final LocalDateTime expiredAt) {
    final QueueToken queueToken = Optional.ofNullable(queueTokenRepository.findByUuid(uuid))
      .orElseThrow(() -> new TokenNotFoundException(TokenErrorType.TOKEN_NOT_FOUND));

    return queueToken.isValidProcessingToken(expiredAt);
  }
}
