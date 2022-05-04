package com.zq.secondarymarket.controller;


import com.zq.secondarymarket.bean.Pagination;
import com.zq.secondarymarket.bean.Response;
import com.zq.secondarymarket.entity.User;
import com.zq.secondarymarket.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService iUserService;

    // 用户登录
    @RequestMapping("/login")
    public Response getAllUserList() {
        Response response = new Response();
        List<User> list = iUserService.getAllUserList();
        response.setResultMessage("返回用户数据成功!");
        response.setResultCode("200");
        response.setBeans(list);
        return response;
    }

    // 判断账号密码是否正确
    @RequestMapping("/allowLogin")
    public Response allowLogin(@RequestParam("userId") String userId, @RequestParam("password") String password) {
        Response response = new Response();
        System.out.println("userId:" + userId + " password:" + password);
        List<User> list = iUserService.allowLogin(userId, password);
        if (list.size() == 0) {
            response.setResultMessage("账号密码错误!");
            response.setResultCode("404");
        } else {
            response.setResultMessage("账号密码正确!");
            response.setResultCode("200");
        }
        response.setBeans(list);
        return response;
    }

    // 根据用户id查询用户信息
    @RequestMapping("/getUserById")
    public Response getUserById(@RequestParam("userId") String userId) {
        Response response = new Response();
        User user = iUserService.getUserById(userId);
        response.setResultMessage("返回用户数据成功!");
        response.setResultCode("200");
        response.setBean(user);
        return response;
    }

    // 注册用户
    @RequestMapping("/logon")
    public Response logon(@RequestParam("userId") String userId, @RequestParam("password") String password) {
        Response response = new Response();
        User user = new User();
        user.setUserId(userId);
        user.setPassword(password);
        int result = iUserService.registerUser(user);
        if (result == 1) {
            response.setResultMessage("注册成功!");
            response.setResultCode("200");
        } else {
            response.setResultMessage("注册失败!");
            response.setResultCode("404");
        }
        return response;
    }

    // 更新用户信息
    @RequestMapping("/updateUser")
    public Response updateUser(@RequestParam("userId") String userId,
                               @RequestParam("password") String password,
                               @RequestParam("userName") String userName,
                               @RequestParam("grade") String grade,
                               @RequestParam("phone") String phone,
                               @RequestParam("qq") String qq,
                               @RequestParam("sex") String sex,
                               @RequestParam("receiveAddress") String receiveAddress,
                               @RequestParam("nowAddress") String nowAddress,
                               @RequestParam("goodType") String goodType,
                               @RequestParam("userType") String userType,
                               @RequestParam("description") String description) {
        Response response = new Response();
        User user = new User();
        user.setUserId(userId);
        user.setPassword(password);
        user.setUserName(userName);
        user.setGrade(grade);
        user.setPhone(phone);
        user.setQq(qq);
        user.setSex(sex);
        user.setReceiveAddress(receiveAddress);
        user.setNowAddress(nowAddress);
        user.setGoodType(goodType);
        user.setUserType(userType);
        user.setDescription(description);
        int result = iUserService.updateUser(user);
        if (result == 1) {
            response.setResultMessage("更新用户信息成功!");
            response.setResultCode("200");
        } else {
            response.setResultMessage("更新用户信息失败!");
            response.setResultCode("404");
        }
        return response;
    }
    
    // 删除用户
    @RequestMapping("/deleteUser")
    public Response deleteUser(@RequestParam("userId") String userId) {
        Response response = new Response();
        int result = iUserService.deleteUserById(userId);
        if (result == 1) {
            response.setResultMessage("删除用户成功!");
            response.setResultCode("200");
        } else {
            response.setResultMessage("删除用户失败!");
            response.setResultCode("404");
        }
        return response;
    }

    // 用户数据分页获取
    @RequestMapping("/getUserList")
    public Response getUserList(@RequestParam("pageNum") Integer pageNum,
    @RequestParam("pageSize") Integer pageSize,
            @RequestParam(value = "grade", required = false) String grade,
            @RequestParam(value = "userType", required = false) String userType,
    @RequestParam(value = "searchValue", required = false) String searchValue) {
        Map<String, Object> map = new HashMap<>();
        map.put("pageNum", (pageNum - 1) * pageSize);
        map.put("pageSize", pageSize);
        if (grade != null && !grade.equals("")) {
            map.put("grade", grade);
        }
        if (userType != null && !userType.equals("")) {
            map.put("userType", userType);
        }
        if (searchValue != null && !searchValue.equals("")) {
            map.put("searchValue", searchValue);
        }
        List<User> list = iUserService.getUserListByPage(map);
        Pagination pagination = new Pagination();
        pagination.setCurrent(pageNum);
        pagination.setPageSize(pageSize);
        pagination.setTotal((long) iUserService.getUserCount(grade, searchValue, userType));
        pagination.setList(list);
        Response response = new Response();
        response.setResultMessage("返回用户数据成功!");
        response.setResultCode("200");
        response.setBean(pagination);
        return response;

    }
    
}
