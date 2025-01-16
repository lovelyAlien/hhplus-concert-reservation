package kr.hhplus.be.server.application.service;

import kr.hhplus.be.server.domain.entity.Payment;
import kr.hhplus.be.server.domain.enums.PaymentStatus;
import kr.hhplus.be.server.domain.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PaymentService {

  private final PaymentRepository paymentRepository;

  public void addPaymentRecord(
    long reservationId, long userId, BigDecimal amount, LocalDateTime now, PaymentStatus status) {
    Payment payment = Payment.create(reservationId, userId, amount, now, status);
    paymentRepository.save(payment);
  }

}
