package dev.thiaago.aiqdrinkapi.service;

import dev.thiaago.aiqdrinkapi.adapter.DrinkAdapter;
import dev.thiaago.aiqdrinkapi.dto.CreateDrinkDTO;
import dev.thiaago.aiqdrinkapi.dto.DrinkDTO;
import dev.thiaago.aiqdrinkapi.repository.DrinkRepository;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrinkService {
    private final DrinkRepository drinkRepository;
    private final DrinkAdapter drinkAdapter;

    public DrinkService(DrinkRepository repository, DrinkAdapter drinkAdapter) {
        this.drinkRepository = repository;
        this.drinkAdapter = drinkAdapter;
    }

    public List<DrinkDTO> getAll() {
        return drinkRepository
                .findAll()
                .stream()
                .map(drinkAdapter::toDrinkDTO).toList();
    }

    public DrinkDTO getById(Long id) throws ChangeSetPersister.NotFoundException {
        return drinkAdapter.toDrinkDTO(drinkRepository.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new));
    }

    public DrinkDTO save(CreateDrinkDTO drink) {
        return drinkAdapter.toDrinkDTO(drinkRepository.save(drinkAdapter.toDrink(drink)));
    }
}
