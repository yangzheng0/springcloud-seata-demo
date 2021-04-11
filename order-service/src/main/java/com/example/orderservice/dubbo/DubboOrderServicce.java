package com.example.orderservice.dubbo;

import com.alibaba.dubbo.config.annotation.Service;
import com.example.orderservice.service.OrderService;
import com.example.seata.api.IDubboOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author yangzheng
 * @version 1.0
 * @description
 * @date 2021/4/11 011 15:52
 */
@Service
@Slf4j
public class DubboOrderServicce implements IDubboOrderService {
    @Autowired
    OrderService orderService;

    @Override
    public boolean create(@RequestParam String userId, @RequestParam String commodityCode, @RequestParam Integer count) {
        log.info("【下单】,userId={},commodityCode={},count={}", userId, commodityCode,count);
        return orderService.create(userId, commodityCode, count);
    }
}
