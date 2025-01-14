package kr.hhplus.be.server.presentation.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import kr.hhplus.be.server.domain.enums.SeatStatus;

@Schema(description = "좌석 정보를 반환합니다.")
public record ConcertSeatResponse (
  @Schema(description = "좌석 번호")
  String seatNo,
  @Schema(description = "좌석 상태")
  SeatStatus status
) {}

