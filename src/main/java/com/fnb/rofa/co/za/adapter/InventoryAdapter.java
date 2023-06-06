package com.fnb.rofa.co.za.adapter;

import com.fnb.rofa.co.za.model.Order;

import java.time.LocalDateTime;

public interface InventoryAdapter {
    String getJiraHoursLogged(String employeeId);
    Order findByUserId(Long userId);
}
