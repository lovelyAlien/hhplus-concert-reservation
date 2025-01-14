package kr.hhplus.be.server.application.service;

import kr.hhplus.be.server.domain.entity.User;
import kr.hhplus.be.server.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;

  public User findUserById(Long userId) {
    return userRepository.findById(userId);
  }
}
