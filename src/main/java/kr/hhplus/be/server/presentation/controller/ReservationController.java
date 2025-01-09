package kr.hhplus.be.server.presentation.controller;

import kr.hhplus.be.server.presentation.dto.SeatReserveRequest;
import kr.hhplus.be.server.presentation.dto.SeatReserveResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ReservationController {
  // 콘서트 예약
  @GetMapping("/seats/reserve")
  public ResponseEntity<SeatReserveResponse> reserveSeat(
    @CookieValue(name="queuetoken", required = false) String token,
    @RequestBody SeatReserveRequest request
  ) {
    SeatReserveResponse response = new SeatReserveResponse(
      "SUCCESS",
      String.format("좌석 예약 요청이 성공적으로 접수되었습니다. (user=%s, seat=%s) 5분 간 HOLD 유지",
        request.getUserId(), request.getSeatId())
    );
    return ResponseEntity.ok(response);
  }
}
