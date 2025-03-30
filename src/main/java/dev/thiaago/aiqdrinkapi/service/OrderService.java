package dev.thiaago.aiqdrinkapi.service;

import dev.thiaago.aiqdrinkapi.dto.CreateOrderDTO;
import dev.thiaago.aiqdrinkapi.model.Drink;
import dev.thiaago.aiqdrinkapi.model.Order;
import dev.thiaago.aiqdrinkapi.repository.DrinkRepository;
import dev.thiaago.aiqdrinkapi.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final DrinkRepository drinkRepository;

    public OrderService(OrderRepository orderRepository, DrinkRepository drinkRepository) {
        this.orderRepository = orderRepository;
        this.drinkRepository = drinkRepository;
    }

    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    public Order save(CreateOrderDTO orderDTO) {
        final Drink drink = drinkRepository.findById(orderDTO.drinkId())
                .orElseThrow(() -> new RuntimeException("Drink not found"));

        Order order = new Order();
        order.setDrink(drink);
        order.setCustomerName(orderDTO.customerName());

        return orderRepository.save(order);
    }

    public void deleteById(Long id) {
        orderRepository.deleteById(id);
    }
}
