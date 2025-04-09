package dev.thiaago.aiqdrinkapi.adapter;

import dev.thiaago.aiqdrinkapi.dto.CreateDrinkDTO;
import dev.thiaago.aiqdrinkapi.dto.DrinkDTO;
import dev.thiaago.aiqdrinkapi.model.Drink;
import org.springframework.stereotype.Component;

@Component
public class DrinkAdapter {

    public DrinkDTO toDrinkDTO(Drink drink) {
        return new DrinkDTO(
                drink.getId(),
                drink.getName(),
                drink.getDescription(),
                drink.getRecipe(),
                drink.getPhotoUrl()
        );
    }

    public Drink toDrink(CreateDrinkDTO drinkDto) {
        return new Drink(
                drinkDto.name(),
                drinkDto.description(),
                drinkDto.recipe(),
                drinkDto.photoUrl()
        );
    }
}
