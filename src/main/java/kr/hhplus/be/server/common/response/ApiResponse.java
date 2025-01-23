package kr.hhplus.be.server.common.response;

import kr.hhplus.be.server.common.error.ErrorMessage;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@NoArgsConstructor(force = true)
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class ApiResponse<S> {

  private final ResultType result;

  private final S data;

  private final ErrorMessage error;

  public static ApiResponse<?> success() {
    return new ApiResponse<>(ResultType.SUCCESS, null, null);
  }

  public static <S> ApiResponse<S> success(S data) {
    return new ApiResponse<>(ResultType.SUCCESS, data, null);
  }

  public static ApiResponse<?> error(final String code, final String message) {
    return new ApiResponse<>(ResultType.ERROR, null, new ErrorMessage(code, message));
  }

  public static ApiResponse<?> error(final String code, final String message, Object errorData) {
    return new ApiResponse<>(ResultType.ERROR, null, new ErrorMessage(code, message, errorData));
  }
}