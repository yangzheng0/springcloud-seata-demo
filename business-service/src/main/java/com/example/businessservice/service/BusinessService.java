package com.example.businessservice.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.example.seata.api.IDubboOrderService;
import com.example.seata.api.IDubboUserService;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@Slf4j
public class BusinessService {


    @Autowired
    OrderService orderService;

    @Autowired
    UserService userService;

    @Reference(check = false)
    IDubboUserService dubboUserService;

    @Reference(check = false)
    IDubboOrderService dubboOrderService;

    /**
     * 减库存，下订单
     *
     */
    @GlobalTransactional
    public void purchase() {
        log.info("【下单 扣款】");
        orderService.create("1001","123",1);
        userService.debit("1001",new BigDecimal(6));
    }

    @GlobalTransactional
    public void purchase2() {
        log.info("【feign 下单 扣款】");
        boolean orderFlag = orderService.create("1001", "123", 1);
        boolean userFlag = userService.debit("1001",new BigDecimal(6));
    }

    @GlobalTransactional
    public void purchase3() {
        log.info("【dubbo 下单 扣款】");
        boolean orderFlag = dubboOrderService.create("1001", "123", 1);
        boolean userFlag = dubboUserService.debit("1001",new BigDecimal(6));
    }
}
