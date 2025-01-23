package kr.hhplus.be.server.common.error;

public abstract class TokenException extends RuntimeException {
  private final TokenErrorType errorType;

  public TokenException(final TokenErrorType errorType) {
    super(errorType.getMessage());
    this.errorType = errorType;
  }
}
