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
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private String fullName;
    private Long userId;
    private String idNumber;
    private String email;
    private String contactNumber;
    private String items;
    private LocalDateTime date;

    @OneToOne
    @JoinColumn(name = "invoice_id")
    private Invoice invoice;
}
