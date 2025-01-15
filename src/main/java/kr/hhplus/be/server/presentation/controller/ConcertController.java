package kr.hhplus.be.server.presentation.controller;

import kr.hhplus.be.server.domain.enums.SeatStatus;
import kr.hhplus.be.server.presentation.dto.ConcertDateResponse;
import kr.hhplus.be.server.application.facade.ConcertFacade;
import kr.hhplus.be.server.presentation.dto.ConcertSeatResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ConcertController {
  private final ConcertFacade concertFacade;

  // 예약 가능 날짜 조회
  @GetMapping("/dates/available")
  public ResponseEntity<List<ConcertDateResponse>> getAvailableDates(
    @RequestParam(value="concertId", required = false) Long concertId
  ) {

    // 하드 코딩된 날짜 목록(JSON 배열 문자열)
    List<ConcertDateResponse> dates = concertFacade.findAvailableDates(concertId, LocalDateTime.now());
    return ResponseEntity.ok(dates);
  }

  // 예약 가능 좌석 조회
  @GetMapping("/seats/available")
  public ResponseEntity<List<ConcertSeatResponse>> getAvailableSeats(
    @RequestParam(value="scheduleId", required = false) Long scheduleId,
    @RequestParam(value="userId", required = false) Long userId,
    @CookieValue(name="queueToken", required = false) String token
  ) {
    // (실제 로직이라면 token 유효성, date·userId 검증 로직이 필요)
    // 단순 하드코딩 응답
    List<ConcertSeatResponse> response = concertFacade.findAvailableSeats(scheduleId, SeatStatus.AVAILABLE);
    return ResponseEntity.ok(response);
  }
}
