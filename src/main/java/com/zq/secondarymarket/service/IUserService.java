package com.zq.secondarymarket.service;

import com.zq.secondarymarket.entity.User;

import java.util.List;
import java.util.Map;

public interface IUserService {
    /**
     * 查询所有用户
     * @return
     */
    List<User> getAllUserList();
    /**
     * 判断账号密码是否正确
     * @param userId
     * @param password
     * @return
     */
    List<User> allowLogin(String userId, String password);

    // 根据用户id查询用户信息
    User getUserById(String userId);

    // 注册用户
    int registerUser(User user);

    // 更新用户信息
    int updateUser(User user);

    // 根据用户id删除用户
    int deleteUserById(String userId);

    // 分页获取用户数据
    List<User> getUserListByPage(Map<String, Object> map);
    // 获取用户总数
    int getUserCount(String grade, String searchValue);
}
