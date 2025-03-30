package dev.thiaago.aiqdrinkapi.service;

import dev.thiaago.aiqdrinkapi.model.Drink;
import dev.thiaago.aiqdrinkapi.repository.DrinkRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DrinkService {
    private final DrinkRepository drinkRepository;

    public DrinkService(DrinkRepository repository) {
        this.drinkRepository = repository;
    }

    public List<Drink> getAll() {
        return drinkRepository.findAll();
    }

    public Optional<Drink> getById(Long id) {
        return drinkRepository.findById(id);
    }

    public Drink save(Drink drink) {
        return drinkRepository.save(drink);
    }
}
