package school.hei.tsinjo.repository;

public interface PaymentRepository {
    void save(Payment payment);
    void update(Payment payment);
    Optional<Payment> findById(UUID id);
    List<Payment> findByStatus(PaymentStatus status);
}
