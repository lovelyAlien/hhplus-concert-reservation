package kr.hhplus.be.server.common.error;

public class TokenInvalidException extends TokenException {
  public TokenInvalidException(final TokenErrorType errorType) {
    super(errorType);
  }
}
