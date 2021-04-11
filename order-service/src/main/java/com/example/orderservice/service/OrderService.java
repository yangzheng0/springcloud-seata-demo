package com.example.orderservice.service;

import com.example.orderservice.dao.OrderMapper;
import com.example.orderservice.entity.Order;
import io.seata.core.context.RootContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class OrderService {

//    @Autowired
//    private AccountClient accountClient;
    @Autowired
    private OrderMapper orderMapper;

    public boolean create(String userId, String commodityCode, Integer count) {
        System.out.println("storage XID " + RootContext.getXID());
        BigDecimal orderMoney = new BigDecimal(count).multiply(new BigDecimal(5));
        Order order = new Order();
        order.setUserId(userId);
        order.setCommodityCode(commodityCode);
        order.setCount(count);
        order.setMoney(orderMoney);

        orderMapper.insert(order);

//        accountClient.debit(userId, orderMoney);
        return true;
    }
}
