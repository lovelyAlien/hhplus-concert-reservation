package kr.hhplus.be.server.application.service;

import kr.hhplus.be.server.common.error.InvalidTokenException;
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

    // 기존 토큰 만료
    expireTokens(userId, concertId);

    // 새 토큰 생성 및 반환
    QueueToken newToken = createAndSaveNewToken(userId, concertId, now);

    return newToken.getUuid();
  }

  public QueueToken getToken(String uuid, QueueTokenStatus status) {
    Optional<QueueToken> opt = queueTokenRepository.findByUuidAndStatus(uuid, status);
    return opt.orElseThrow(() -> new InvalidTokenException("Not found token"));
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

  private void expireTokens(Long userId, Long concertId) {
    List<QueueToken> nonExpiredTokens = queueTokenRepository.findNonExpiredTokens(
      userId, concertId, QueueTokenStatus.EXPIRED);

    nonExpiredTokens.forEach(QueueToken::expire);
  }

  private QueueToken createAndSaveNewToken(Long userId, Long concertId, LocalDateTime now) {
    QueueToken newToken = QueueToken.createNewToken(userId, concertId, now, now.plusMinutes(10));
    return queueTokenRepository.save(newToken);
  }
}
