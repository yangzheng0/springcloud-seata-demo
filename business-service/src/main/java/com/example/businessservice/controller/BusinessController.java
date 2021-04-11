package com.example.businessservice.controller;

import com.example.businessservice.service.BusinessService;
import com.example.businessservice.service.OrderService;
import com.example.businessservice.service.UserService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RequestMapping("/business")
@RestController
@Slf4j
public class BusinessController {

    @Autowired
    BusinessService businessService;

    @RequestMapping(value = "/business1")
    @GlobalTransactional
    public void business1() {
        log.info("【下单 扣款】");
        businessService.purchase();
    }


    @RequestMapping(value = "/business2")
    public String business2() {
        log.info("【feign 下单 扣款】");
        try {
            businessService.purchase2();
        } catch (Exception e) {
            e.printStackTrace();
            return "feign 下单 扣款 失败";
        }
        return "feign 下单 扣款 成功";
    }

    @RequestMapping(value = "/business3")
    public String business3() {
        log.info("【dubbo 下单 扣款】");
        try {
            businessService.purchase3();
        } catch (Exception e) {
            e.printStackTrace();
            return "dubbo 下单 扣款 失败";
        }
        return "dubbo 下单 扣款 成功";
    }

}
