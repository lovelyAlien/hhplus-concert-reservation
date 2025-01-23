package kr.hhplus.be.server.interfaces;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.hhplus.be.server.application.service.QueueTokenValidationService;
import kr.hhplus.be.server.common.annotations.Interceptor;
import kr.hhplus.be.server.common.error.TokenErrorType;
import kr.hhplus.be.server.common.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.servlet.HandlerInterceptor;

import java.time.LocalDateTime;

@Interceptor
@RequiredArgsConstructor
public class QueueTokenValidationInterceptor implements HandlerInterceptor {
  private static final String QUEUE_TOKEN_HEADER_NAME = "QUEUE-TOKEN";

  private final QueueTokenValidationService queueTokenValidationService;
  private final ObjectMapper objectMapper;

  @Override
  public boolean preHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler)
    throws Exception {

    final String uuid = request.getHeader(QUEUE_TOKEN_HEADER_NAME);
    final boolean tokenProcessingValid =
      queueTokenValidationService.validateQueueTokenProcessing(uuid, LocalDateTime.now());

    if (!tokenProcessingValid) {
      final TokenErrorType errorType = TokenErrorType.PROCESSING_TOKEN_INVALID;
      final ApiResponse<?> errorResponse = ApiResponse.error(errorType.getErrorCode().name(), errorType.getMessage());

      response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
      response.getWriter().write(objectMapper.writeValueAsString(errorResponse));
      return false;
    }

    return HandlerInterceptor.super.preHandle(request, response, handler);
  }
}
