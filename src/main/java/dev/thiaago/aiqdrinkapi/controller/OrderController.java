package dev.thiaago.aiqdrinkapi.controller;

import dev.thiaago.aiqdrinkapi.dto.CreateOrderDTO;
import dev.thiaago.aiqdrinkapi.dto.OrderDTO;
import dev.thiaago.aiqdrinkapi.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<OrderDTO> getAll() {
        return orderService.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderDTO create(@RequestBody CreateOrderDTO order) {
        return orderService.save(order);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        orderService.deleteById(id);
    }
}
