package com.example.orderservice;

import com.example.orderservice.service.OrderService;
import com.example.orderservice.service.UserService;
import io.seata.spring.annotation.GlobalTransactional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderServiceApplicationTests {

    @Autowired
    OrderService orderService;

    @Autowired
    UserService userService;

    @Test
    @GlobalTransactional
    public void contextLoads() {
        orderService.create("1001","123",1);
        userService.debit("1002",new BigDecimal(6));
    }


    @Test
    @GlobalTransactional
    public void contextLoads1() {
        orderService.create("1001","123",1);
        userService.debit("1001",new BigDecimal(6));
    }

}
