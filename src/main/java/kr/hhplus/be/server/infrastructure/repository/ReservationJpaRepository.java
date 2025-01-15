package kr.hhplus.be.server.infrastructure.repository;

import kr.hhplus.be.server.domain.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationJpaRepository extends JpaRepository<Reservation, Long> {

}
