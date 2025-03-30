package dev.thiaago.aiqdrinkapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "drinks")
public class Drink {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(length = 2000)
    private String description;
    @Column(length = 2000)
    private String recipe;
    @Column(length = 1000)
    private String photoUrl;

    public Drink(String name, String description, String recipe, String photoUrl) {
        this.name = name;
        this.description = description;
        this.recipe = recipe;
        this.photoUrl = photoUrl;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getRecipe() {
        return recipe;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public Drink() {}
}
