package kr.hhplus.be.server.infrastructure.repository;

import kr.hhplus.be.server.domain.entity.Payment;
import kr.hhplus.be.server.domain.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PaymentRepositoryImpl implements PaymentRepository {
  private final PaymentJpaRepository paymentJpaRepository;
  @Override
  public Payment save(Payment payment) {
    return paymentJpaRepository.save(payment);
  }
}
