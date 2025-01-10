package kr.hhplus.be.server.domain.repository;

import kr.hhplus.be.server.domain.entity.User;

public interface UserRepository {
  User findById(Long userId);
}
