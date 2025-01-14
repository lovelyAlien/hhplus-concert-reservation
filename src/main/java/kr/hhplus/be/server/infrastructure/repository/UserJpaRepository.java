package kr.hhplus.be.server.infrastructure.repository;

import kr.hhplus.be.server.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<User, Long> {
}
