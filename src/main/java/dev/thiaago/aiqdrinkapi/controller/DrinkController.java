package dev.thiaago.aiqdrinkapi.controller;

import dev.thiaago.aiqdrinkapi.dto.CreateDrinkDTO;
import dev.thiaago.aiqdrinkapi.dto.DrinkDTO;
import dev.thiaago.aiqdrinkapi.service.DrinkService;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/drinks")
public class DrinkController {
    private final DrinkService drinkService;

    public DrinkController(DrinkService drinkService) {
        this.drinkService = drinkService;
    }

    @GetMapping
    public List<DrinkDTO> getAll() {
        return drinkService.getAll();
    }

    @GetMapping("/{id}")
    public DrinkDTO getById(@PathVariable("id") String id) throws ChangeSetPersister.NotFoundException {
        return drinkService.getById(Long.getLong(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DrinkDTO create(@RequestBody CreateDrinkDTO drink) {
        return drinkService.save(drink);
    }
}
