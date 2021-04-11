package com.example.userservice.controller;

import com.example.userservice.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/user")
@Slf4j
public class AccountController {

    @Autowired
    AccountService accountService;

    @RequestMapping("/debit")
    public boolean debit(@RequestParam String userId, @RequestParam BigDecimal orderMoney) {
        log.info("【扣款】,userId={},orderMoney={}",userId,orderMoney);
        return accountService.debit(userId, orderMoney);
    }

}
