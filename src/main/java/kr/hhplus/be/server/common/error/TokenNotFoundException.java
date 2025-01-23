package kr.hhplus.be.server.common.error;

public class TokenNotFoundException extends TokenException {
  public TokenNotFoundException(final TokenErrorType errorType) {
    super(errorType);
  }
}
