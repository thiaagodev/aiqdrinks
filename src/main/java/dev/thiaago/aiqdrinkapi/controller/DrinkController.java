package dev.thiaago.aiqdrinkapi.controller;

import dev.thiaago.aiqdrinkapi.model.Drink;
import dev.thiaago.aiqdrinkapi.service.DrinkService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/drinks")
public class DrinkController {
    private final DrinkService drinkService;

    public DrinkController(DrinkService drinkService) {
        this.drinkService = drinkService;
    }

    @GetMapping
    public List<Drink> getAll() {
        return drinkService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Drink> getById(@PathVariable("id") String id) {
        return drinkService.getById(Long.getLong(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Drink create(@RequestBody Drink drink) {
        return drinkService.save(drink);
    }
}
