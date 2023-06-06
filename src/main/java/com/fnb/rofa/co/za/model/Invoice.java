package com.fnb.rofa.co.za.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@ToString
@Getter
@Setter
@Entity
//@Table(name = "orders")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    private LocalDateTime date;
    private String account;

//    @OneToOne
//    @JoinColumn(name = "order_id")
//    private Order order;
}
