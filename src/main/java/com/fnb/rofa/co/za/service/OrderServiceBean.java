package com.fnb.rofa.co.za.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fnb.rofa.co.za.adapter.InventoryAdapter;
import com.fnb.rofa.co.za.dto.InventoryDTO;
import com.fnb.rofa.co.za.dto.OrderDTO;
import com.fnb.rofa.co.za.model.Invoice;
import com.fnb.rofa.co.za.model.Order;
import com.fnb.rofa.co.za.repository.InvoiceRepository;
import com.fnb.rofa.co.za.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderServiceBean implements OrderService {

    private final OrderRepository orderRepository;
    private final InventoryAdapter inventoryAdapter;
    private final InvoiceRepository invoiceRepository;

    public OrderServiceBean(OrderRepository orderRepository, InventoryAdapter inventoryAdapter, InvoiceRepository invoiceRepository) {
        this.orderRepository = orderRepository;
        this.inventoryAdapter = inventoryAdapter;
        this.invoiceRepository = invoiceRepository;
    }

    @Override
    public Order createOrder(OrderDTO orderDTO) throws JsonProcessingException {
        System.out.println(orderDTO);
        Invoice invoice = new Invoice();
        LocalDateTime date = LocalDateTime.now();
        Order order = new Order();
        order.setEmail(orderDTO.getEmail());
        order.setDate(date);
        order.setItems(orderDTO.getItems());
        order.setContactNumber(orderDTO.getContactNumber());
        order.setFullName(orderDTO.getFullName());
        order.setUserId(orderDTO.getUserId());
        order.setInvoice(invoice);

        String stockAvailability = inventoryAdapter.getJiraHoursLogged(orderDTO.getItems());
        Order customerOrder = orderRepository.findByUserId(orderDTO.getUserId());

        boolean xxxx = orderRepository.existsOrderByUserId(orderDTO.getUserId());
        if(xxxx==false){
            if (orderDTO.getItems().equals("0")) {

                ObjectMapper objectMapper = new ObjectMapper();
                InventoryDTO inventoryDTO = objectMapper.readValue(stockAvailability, InventoryDTO.class);

                if (inventoryDTO.getName().equals("Available")) {

                    invoice.setDate(date);
                    invoice.setAccount("62790019098");

                    invoiceRepository.save(invoice);
                    return orderRepository.save(order);
                }
            } else {
                return order;
            }
        }else{
            System.out.println("Exists");
        }

        return order;
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order findByUserId(Long userId) {
        //Order orders = orderRepository.findAllByUserId(userId).get(0);

//        for(Order order: orders){
//            System.out.println(order.getId());
//        }

        return orderRepository.findByUserId(userId);
    }

    @Override
    public List<Order> findAllByUserId(Long userId) {
        return orderRepository.findAllByUserId(userId);
    }
}
