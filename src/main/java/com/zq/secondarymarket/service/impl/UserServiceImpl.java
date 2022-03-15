package com.zq.secondarymarket.service.impl;

import com.zq.secondarymarket.entity.User;
import com.zq.secondarymarket.mapper.UserMapper;
import com.zq.secondarymarket.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public List<User> getAllUserList() {
        return userMapper.getAllUserList();
    }
}
