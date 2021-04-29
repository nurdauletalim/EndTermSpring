package kz.iitu.phoneStore.repositories;

import kz.iitu.phoneStore.entity.reservation.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
