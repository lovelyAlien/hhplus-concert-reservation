package kr.hhplus.be.server.presentation.controller;

import kr.hhplus.be.server.presentation.dto.PaymentRequest;
import kr.hhplus.be.server.presentation.dto.PaymentResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PaymentController {
  // 결제
  @GetMapping("/payment")
  public ResponseEntity<PaymentResponse> doPayment(
    @CookieValue(name="queueToken", required=false) String token,
    @RequestBody PaymentRequest request
  ) {
    // (실제 로직이라면 잔액 검증, seat HOLD 상태 확인 등)
    PaymentResponse response = new PaymentResponse(
      "SUCCESS",
      "결제 완료. 좌석 예약이 확정되었습니다."
    );
    return ResponseEntity.ok(response);
  }
}

