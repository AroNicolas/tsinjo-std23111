package school.hei.tsinjo.repository;

import school.hei.tsinjo.model.Payment;
import school.hei.tsinjo.model.PaymentStatus;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PaymentRepository {
  void save(Payment payment);

  void update(Payment payment);

  Optional<Payment> findById(UUID id);

  List<Payment> findByStatus(PaymentStatus status);
}
