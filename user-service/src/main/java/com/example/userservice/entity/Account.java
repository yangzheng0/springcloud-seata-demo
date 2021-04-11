package com.example.userservice.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Account {
    private Integer id;

    private String userId;

    private BigDecimal money;

}