package com.example.seata.api;

/**
 * @author yangzheng
 * @version 1.0
 * @description
 * @date 2021/4/11 011 15:42
 */
public interface IDubboOrderService {
    boolean create(String userId, String commodityCode, Integer count);
}
