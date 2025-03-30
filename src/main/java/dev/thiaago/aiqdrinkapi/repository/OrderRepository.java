package dev.thiaago.aiqdrinkapi.repository;

import dev.thiaago.aiqdrinkapi.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
