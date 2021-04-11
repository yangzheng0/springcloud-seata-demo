package com.example.userservice.dao;

import com.example.userservice.entity.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AccountMapper {

    Account selectByUserId(@Param("userId") String userId);

    int updateById(Account record);

}