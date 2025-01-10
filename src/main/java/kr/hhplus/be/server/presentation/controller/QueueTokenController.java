package kr.hhplus.be.server.presentation.controller;

import kr.hhplus.be.server.application.service.QueueTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class QueueTokenController {

  private final QueueTokenService queueTokenService;

  // 대기열 토큰 발급
  @GetMapping("/tokens/issue")
  public ResponseEntity<String> issueQueueToken(
    @RequestParam(value="userId", required = false) Long userId,
  @RequestParam(value="concertId", required = false) Long concertId) {

    String mockToken = queueTokenService.createQueueToken(userId, concertId);
    return ResponseEntity.ok(mockToken);
  }
}
