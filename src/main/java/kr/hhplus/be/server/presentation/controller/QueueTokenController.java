package kr.hhplus.be.server.presentation.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class QueueTokenController {
  // 대기열 토큰 발급
  @GetMapping("/tokens/issue")
  public ResponseEntity<String> createQueueToken(
    @RequestParam(value="userId", required = false) String userId) {
    String mockToken = "cc245016-f7b1-49fa-8495-abf5885aa676";
    return ResponseEntity.ok(mockToken);
  }
}
