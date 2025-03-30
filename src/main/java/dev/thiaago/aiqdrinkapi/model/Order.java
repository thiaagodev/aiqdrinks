package dev.thiaago.aiqdrinkapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerName;

    @ManyToOne
    @JoinColumn(name = "drink_id", nullable = false)
    private Drink drink;

    public Order(String customerName, Drink drink) {
        this.customerName = customerName;
        this.drink = drink;
    }

    public Order() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setDrink(Drink drink) {
        this.drink = drink;
    }

    public Long getId() {
        return id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public Drink getDrink() {
        return drink;
    }
}
