package com.example.userservice;

import com.example.userservice.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceApplicationTests {

    @Autowired
    AccountService accountService;

    @Test
    public void contextLoads() {
        accountService.debit("1001",new BigDecimal(5));
    }

}
