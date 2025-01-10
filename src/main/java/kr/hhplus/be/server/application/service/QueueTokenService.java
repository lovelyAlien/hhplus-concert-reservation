package kr.hhplus.be.server.application.service;

import kr.hhplus.be.server.domain.entity.QueueToken;
import kr.hhplus.be.server.domain.repository.QueueTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class QueueTokenService {

  private final QueueTokenRepository queueTokenRepository;

  @Transactional
  public String createQueueToken(Long userId, Long concertId) {

    // 기존 토큰 만료
    expireTokens(userId, concertId);

    // 새 토큰 생성 및 반환
    QueueToken newToken = createAndSaveNewToken(userId, concertId);

    return newToken.getUuid();
  }

  private void expireTokens(Long userId, Long concertId) {
    List<QueueToken> nonExpiredTokens = queueTokenRepository.findNonExpiredTokens(
      userId, concertId, QueueToken.Status.EXPIRED);

    nonExpiredTokens.forEach(QueueToken::expire);
  }

  private QueueToken createAndSaveNewToken(Long userId, Long concertId) {
    QueueToken newToken = QueueToken.createNewToken(userId, concertId, LocalDateTime.now().plusMinutes(30));
    return queueTokenRepository.save(newToken);
  }

}
