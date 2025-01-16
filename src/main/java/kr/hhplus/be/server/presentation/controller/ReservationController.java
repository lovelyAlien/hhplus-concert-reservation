package kr.hhplus.be.server.presentation.controller;

import kr.hhplus.be.server.application.facade.ReservationFacade;
import kr.hhplus.be.server.presentation.dto.SeatReserveRequest;
import kr.hhplus.be.server.presentation.dto.SeatReserveResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ReservationController {
  private final ReservationFacade reservationFacade;
  // 콘서트 예약
  @GetMapping("/seats/reserve")
  public ResponseEntity<SeatReserveResponse> reserveSeat(
    @CookieValue(name="queuetoken", required = false) String token,
    @RequestBody SeatReserveRequest request
  ) {
    SeatReserveResponse response = reservationFacade.reserveSeat(
      request.getSeatId(), request.getUserId(), token, LocalDateTime.now());
    return ResponseEntity.ok(response);
  }
}
