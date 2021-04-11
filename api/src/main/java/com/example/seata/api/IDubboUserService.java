package com.example.seata.api;

import java.math.BigDecimal;

/**
 * @author yangzheng
 * @version 1.0
 * @description
 * @date 2021/4/11 011 15:42
 */
public interface IDubboUserService {
    boolean debit(String userId, BigDecimal orderMoney);
}
