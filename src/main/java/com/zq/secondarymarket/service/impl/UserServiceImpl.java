package com.zq.secondarymarket.service.impl;

import com.zq.secondarymarket.entity.User;
import com.zq.secondarymarket.mapper.UserMapper;
import com.zq.secondarymarket.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    UserMapper userMapper;

    /**
     * 获取所有用户
     * @return
     */
    @Override
    public List<User> getAllUserList() {
        return userMapper.getAllUserList();
    }
    
    // 判断账号密码是否正确
    @Override
    public List<User> allowLogin(String userId, String password) {
        return userMapper.allowLogin(userId, password);
    }

    // 根据用户id查询用户信息
    @Override
    public User getUserById(String userId) {
        return userMapper.getUserById(userId);
    }

    // 注册用户
    @Override
    public int registerUser(User user) {
        return userMapper.registerUser(user);
    }

    // 更新用户信息
    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    // 根据用户id删除用户
    @Override
    public int deleteUserById(String userId) {
        return userMapper.deleteUserById(userId);
    }

    // 分页获取用户数据
    @Override
    public List<User> getUserListByPage(Map<String, Object> map) {
        return userMapper.getUserListByPage(map);
    }
    // 获取用户数量
    @Override
    public int getUserCount(String grade, String searchValue) {
        return userMapper.getUserCount(grade, searchValue);
    }

}
