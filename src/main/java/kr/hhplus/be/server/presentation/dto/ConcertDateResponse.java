package kr.hhplus.be.server.presentation.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import kr.hhplus.be.server.domain.enums.ConcertStatus;

import java.time.LocalDateTime;

@Schema(description = "좌석 정보를 반환합니다.")
public record ConcertDateResponse(
  @Schema(description = "콘서트 스케줄 아이디")
  long scheduleId,

  @Schema(description = "콘서트 공연 날짜")
  LocalDateTime concertStartDateTime,

  @Schema(description = "콘서트 진행 상태")
  ConcertStatus status
) {}
