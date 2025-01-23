package kr.hhplus.be.server.application.service;

import kr.hhplus.be.server.common.error.TokenErrorType;
import kr.hhplus.be.server.common.error.TokenInvalidException;
import kr.hhplus.be.server.domain.entity.QueueToken;
import kr.hhplus.be.server.domain.enums.QueueTokenStatus;
import kr.hhplus.be.server.domain.repository.QueueTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QueueTokenService {

  private final QueueTokenRepository queueTokenRepository;

  @Transactional
  public String createToken(Long userId, Long concertId, LocalDateTime now) {
    // 새 토큰 생성 및 반환
    return createAndSaveNewToken(userId, concertId, now).getUuid();
  }

  public QueueToken getToken(String uuid, QueueTokenStatus status) {
    Optional<QueueToken> opt = queueTokenRepository.findByUuidAndStatus(uuid, status);
    return opt.orElseThrow(() -> new TokenInvalidException(TokenErrorType.TOKEN_NOT_FOUND));
  }

  public int updateToken(List<QueueToken> tokensToUpdate, LocalDateTime now) {
    LocalDateTime expireAt = now.plusMinutes(10);
    for(QueueToken token : tokensToUpdate) {
      token.activate();
      token.setExpiration(expireAt);
    }
    List<QueueToken> tokens = queueTokenRepository.saveAll(tokensToUpdate);
    return tokens.size();
  }

  public int expireToken(List<QueueToken> tokensToExpire) {
    for(QueueToken token : tokensToExpire) {
      token.expire();
    }
    List<QueueToken> tokens = queueTokenRepository.saveAll(tokensToExpire);
    return tokens.size();
  }

  private QueueToken createAndSaveNewToken(Long userId, Long concertId, LocalDateTime now) {
    QueueToken newToken = QueueToken.create(userId, concertId, now, now.plusMinutes(10));
    return queueTokenRepository.save(newToken);
  }
}
