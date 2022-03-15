package com.zq.secondarymarket.service;

import com.zq.secondarymarket.entity.User;

import java.util.List;

public interface IUserService {
    /**
     * 查询所有用户
     * @return
     */
    List<User> getAllUserList();
}
