package kr.hhplus.be.server.presentation.controller;

import kr.hhplus.be.server.presentation.dto.ChargePointRequest;
import kr.hhplus.be.server.presentation.dto.CommonResponse;
import kr.hhplus.be.server.presentation.dto.PointBalanceResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class UserController {
  // 잔액 충전
  @GetMapping("/points/charge")
  public ResponseEntity<CommonResponse> chargePoint(
    @RequestBody ChargePointRequest request
  ) {

    String msg = String.format("포인트 충전이 완료되었습니다. 현재 잔액: %d", 100000);
    return ResponseEntity.ok(new CommonResponse("SUCCESS", msg));

  }
  // 잔액 조회
  @GetMapping("/points/balance")
  public ResponseEntity<PointBalanceResponse> getPointBalance(
    @RequestParam("userId") String userId
  ) {
    // (실제 로직이라면 userId가 유효한지 조회해야 함)
    PointBalanceResponse response = new PointBalanceResponse(userId, 30000);
    return ResponseEntity.ok(response);

  }
}
