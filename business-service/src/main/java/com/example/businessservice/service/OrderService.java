package com.example.businessservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @Author: YuanZheng
 * @Date: 2019/10/8 16:31
 * @Version 1.0
 */
@FeignClient("my-order-service")
public interface OrderService {

    /**
     * @description: 获取金币
     * @param: 
     * @return: 
     * @author: yangzheng
     * @time: 2019/11/11 14:40
     */
    @PostMapping(value = "/api/order/create",produces = "application/json;charset=UTF-8")
    boolean create(@RequestParam("userId") String userId, @RequestParam("commodityCode") String commodityCode, @RequestParam("count") Integer count);
}