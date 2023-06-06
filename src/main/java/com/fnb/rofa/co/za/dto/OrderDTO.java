package com.fnb.rofa.co.za.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;

@ToString
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String fullName;
    private String idNumber;
    private String email;
    private String contactNumber;
    private String items;
    private Long userId;

}