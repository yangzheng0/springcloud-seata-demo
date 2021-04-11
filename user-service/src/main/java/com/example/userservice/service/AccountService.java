package com.example.userservice.service;

import com.example.userservice.dao.AccountMapper;
import com.example.userservice.entity.Account;
import io.seata.core.context.RootContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class AccountService {

    private static final String ERROR_USER_ID = "1002";

    @Autowired
    private AccountMapper accountMapper;

    public boolean debit(String userId, BigDecimal num) {
        System.out.println("storage XID " + RootContext.getXID());
        Account account = accountMapper.selectByUserId(userId);
        account.setMoney(account.getMoney().subtract(num));
        accountMapper.updateById(account);

        if (account.getMoney().compareTo(BigDecimal.ZERO)<0) {
            throw new RuntimeException("余额不足");
        }

//        if (ERROR_USER_ID.equals(userId)) {
//            throw new RuntimeException("account branch exception");
//        }
        return true;
    }

}
