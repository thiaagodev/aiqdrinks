package dev.thiaago.aiqdrinkapi.repository;

import dev.thiaago.aiqdrinkapi.model.Drink;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DrinkRepository extends JpaRepository<Drink, Long> {
}
