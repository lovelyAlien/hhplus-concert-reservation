package kr.hhplus.be.server.presentation.controller;

import io.swagger.v3.oas.annotations.Operation;
import kr.hhplus.be.server.application.facade.PaymentFacade;
import kr.hhplus.be.server.presentation.dto.PaymentRequest;
import kr.hhplus.be.server.presentation.dto.PaymentResponse;
import kr.hhplus.be.server.presentation.dto.PointResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class PaymentController {
  private final PaymentFacade paymentFacade;
  // 결제
  @Operation(summary = "좌석 결제")
  @GetMapping("/payment")
  public ResponseEntity<PaymentResponse> doPayment(
    @CookieValue(name="queueToken", required=false) String token,
    @RequestBody PaymentRequest request
  ) {

    PaymentResponse response = paymentFacade.processPayment(
      request.getReservationId(), request.getSeatId(), request.getUserId(),
      token, request.getAmount(), LocalDateTime.now()
    );
    return ResponseEntity.ok(response);
  }

  @Operation(summary = "포인트 조회")
  @GetMapping("/point")
  public ResponseEntity<PointResponse> getPoint(@RequestParam(value = "userId") Long userId) {
    return ResponseEntity.ok().body(paymentFacade.getPoint(userId));
  }

  @Operation(summary = "포인트 충전")
  @PostMapping("/point/charge")
  public ResponseEntity<PointResponse> pointCharge(@RequestParam(value = "userId") Long userId, @RequestBody BigDecimal amount) {
    return ResponseEntity.ok().body(paymentFacade.chargePoint(userId, amount));
  }
}

