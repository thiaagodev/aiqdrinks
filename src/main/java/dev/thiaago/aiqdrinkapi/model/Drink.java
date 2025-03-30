package dev.thiaago.aiqdrinkapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Drink")
@Getter
@Setter
public class Drink {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String recipe;
    private String photoUrl;

    public Drink(Long id, String name, String description, String recipe, String photoUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.recipe = recipe;
        this.photoUrl = photoUrl;
    }

    public Drink() {}
}
