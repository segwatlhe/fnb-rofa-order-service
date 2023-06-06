package com.fnb.rofa.co.za.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fnb.rofa.co.za.dto.OrderDTO;
import com.fnb.rofa.co.za.model.Order;

import java.util.List;

public interface OrderService {

    Order createOrder(OrderDTO order) throws JsonProcessingException;
    List<Order> findAll();
    Order  findByUserId(Long userId);
    List<Order> findAllByUserId(Long userId);

}
