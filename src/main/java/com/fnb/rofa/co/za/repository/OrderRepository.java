package com.fnb.rofa.co.za.repository;

import com.fnb.rofa.co.za.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, String> {
    Order findByUserId(Long userId);
    Boolean existsOrderByUserId(long userId);
    List<Order> findAllByUserId(Long userId);
}
