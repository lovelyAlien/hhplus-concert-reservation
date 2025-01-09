package kr.hhplus.be.server.presentation.controller;

import kr.hhplus.be.server.presentation.dto.AvailableSeatsResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ConcertController {
  // 예약 가능 날짜 조회
  @GetMapping("/dates/available")
  public ResponseEntity<String> getAvailableDates() {

    // 하드 코딩된 날짜 목록(JSON 배열 문자열)
    String mockDates = "[\"2025-01-10\", \"2025-01-11\", \"2025-01-12\"]";
    return ResponseEntity.ok(mockDates);
  }

  // 예약 가능 좌석 조회
  @GetMapping("/seats/available")
  public ResponseEntity<AvailableSeatsResponse> getAvailableSeats(
    @RequestParam(value="date", required = false) String date,
    @RequestParam(value="userId", required = false) String userId,
    @CookieValue(name="queueToken", required = false) String token
  ) {
    // (실제 로직이라면 token 유효성, date·userId 검증 로직이 필요)
    // 단순 하드코딩 응답
    AvailableSeatsResponse response = new AvailableSeatsResponse(
      (date == null) ? "2025-01-10" : date,
      new String[] {"A1", "A2", "A3"}
    );
    return ResponseEntity.ok(response);
  }
}
