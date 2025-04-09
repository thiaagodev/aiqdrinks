package dev.thiaago.aiqdrinkapi.adapter;

import dev.thiaago.aiqdrinkapi.dto.CreateOrderDTO;
import dev.thiaago.aiqdrinkapi.dto.DrinkDTO;
import dev.thiaago.aiqdrinkapi.dto.OrderDTO;
import dev.thiaago.aiqdrinkapi.model.Drink;
import dev.thiaago.aiqdrinkapi.model.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderAdapter {
    public OrderDTO toOrderDTO(Order order) {
        return new OrderDTO(
                order.getId(),
                order.getCustomerName(),
                new DrinkDTO(
                        order.getDrink().getId(),
                        order.getDrink().getName(),
                        order.getDrink().getDescription(),
                        order.getDrink().getRecipe(),
                        order.getDrink().getPhotoUrl()
                )
        );
    }

    public Order toOrder(CreateOrderDTO orderDTO, Drink drink) {
        return new Order(
                orderDTO.customerName(),
                drink
        );
    }
}
