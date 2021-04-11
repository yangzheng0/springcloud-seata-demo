package com.example.userservice.dubbo;

import com.alibaba.dubbo.config.annotation.Service;
import com.example.seata.api.IDubboOrderService;
import com.example.seata.api.IDubboUserService;
import com.example.userservice.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @author yangzheng
 * @version 1.0
 * @description
 * @date 2021/4/11 011 15:52
 */
@Service
@Slf4j
public class DubboUserService implements IDubboUserService {
    @Autowired
    AccountService accountService;

    @Override
    public boolean debit(String userId, BigDecimal orderMoney) {
        log.info("【扣款】,userId={},orderMoney={}",userId,orderMoney);
        return accountService.debit(userId, orderMoney);
    }
}
