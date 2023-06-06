package com.fnb.rofa.co.za.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@ToString
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class InvoiceDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String fullName;
    private Long userId;
    private String idNumber;
    private String email;
    private String contactNumber;
    private String items;
    private Long invoice;
    private LocalDateTime date;
}