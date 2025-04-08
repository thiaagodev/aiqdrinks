package dev.thiaago.aiqdrinkapi.service;

import dev.thiaago.aiqdrinkapi.adapter.OrderAdapter;
import dev.thiaago.aiqdrinkapi.dto.CreateOrderDTO;
import dev.thiaago.aiqdrinkapi.dto.OrderDTO;
import dev.thiaago.aiqdrinkapi.model.Drink;
import dev.thiaago.aiqdrinkapi.model.Order;
import dev.thiaago.aiqdrinkapi.repository.DrinkRepository;
import dev.thiaago.aiqdrinkapi.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final DrinkRepository drinkRepository;
    private final OrderAdapter orderAdapter;

    public OrderService(OrderRepository orderRepository, DrinkRepository drinkRepository, OrderAdapter orderAdapter) {
        this.orderRepository = orderRepository;
        this.drinkRepository = drinkRepository;
        this.orderAdapter = orderAdapter;
    }

    public List<OrderDTO> getAll() {
        return orderRepository
                .findAll()
                .stream()
                .map(orderAdapter::toOrderDTO).toList();
    }

    public OrderDTO save(CreateOrderDTO orderDTO) {
        final Drink drink = drinkRepository.findById(orderDTO.drinkId())
                .orElseThrow(() -> new RuntimeException("Drink not found"));

        Order order = orderAdapter.toOrder(orderDTO, drink);

        return orderAdapter.toOrderDTO(orderRepository.save(order));
    }

    public void deleteById(Long id) {
        orderRepository.deleteById(id);
    }
}
