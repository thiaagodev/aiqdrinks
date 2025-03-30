package dev.thiaago.aiqdrinkapi.service;

import dev.thiaago.aiqdrinkapi.model.Drink;
import dev.thiaago.aiqdrinkapi.repository.DrinkRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DrinkService {
    private final DrinkRepository repository;

    public DrinkService(DrinkRepository repository) {
        this.repository = repository;
    }

    public List<Drink> getAll() {
        return repository.findAll();
    }

    public Optional<Drink> getById(Long id) {
        return repository.findById(id);
    }

    public Drink create(Drink drink) {
        return repository.save(drink);
    }
}
