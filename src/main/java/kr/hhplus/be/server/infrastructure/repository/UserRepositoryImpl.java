package kr.hhplus.be.server.infrastructure.repository;

import kr.hhplus.be.server.domain.entity.User;
import kr.hhplus.be.server.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

  private final UserJpaRepository userJpaRepository;

  @Override
  public User findById(Long userId) {
    return userJpaRepository.findById(userId)
      .orElseThrow(() -> new IllegalArgumentException("User not found"));
  }
}
