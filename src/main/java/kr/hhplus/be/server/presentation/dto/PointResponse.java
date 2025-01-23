package kr.hhplus.be.server.presentation.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;

@Schema(description = "point를 반환합니다.")
public record PointResponse(
  @Schema(description = "포인트 값")
  BigDecimal point
) {}
