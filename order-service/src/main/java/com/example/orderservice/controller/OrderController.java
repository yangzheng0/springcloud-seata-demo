package com.example.orderservice.controller;

import com.example.orderservice.service.OrderService;
import io.seata.core.context.RootContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/order")
@RestController
@Slf4j
public class OrderController {

    @Autowired
    OrderService orderService;

    @RequestMapping(value = "/create")
    public boolean create(@RequestParam String userId, @RequestParam String commodityCode, @RequestParam Integer count) {
        log.info("【下单】,userId={},commodityCode={},count={}", userId, commodityCode,count);
        return orderService.create(userId, commodityCode, count);
    }

}
