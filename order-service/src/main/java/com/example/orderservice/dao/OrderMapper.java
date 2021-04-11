package com.example.orderservice.dao;

import com.example.orderservice.entity.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {

    int insert(Order record);

}