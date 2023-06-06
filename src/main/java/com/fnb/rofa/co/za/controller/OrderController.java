package com.fnb.rofa.co.za.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fnb.rofa.co.za.dto.OrderDTO;
import com.fnb.rofa.co.za.model.Order;
import com.fnb.rofa.co.za.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/fnb/")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("order/save")
    public Order createOrder(@RequestBody OrderDTO orderDTO) throws JsonProcessingException {
        return orderService.createOrder(orderDTO);
    }

    @GetMapping("order/list")
    public List<Order> findAll() {
        return orderService.findAll();
    }

    @GetMapping("order/list/{userId}")
    public List<Order> findAllByUserId(@PathVariable Long userId) {
        return orderService.findAllByUserId(userId);
    }

    @GetMapping("order/find/{userId}")
    public Order findByUserId2(@PathVariable Long userId) {
        return orderService.findByUserId(userId);
    }

    @GetMapping("order/invoice/{userId}")
    public Order findByUserId(@PathVariable Long userId) {
        return orderService.findByUserId(userId);
    }

}
