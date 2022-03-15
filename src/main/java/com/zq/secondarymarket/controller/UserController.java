package com.zq.secondarymarket.controller;


import com.zq.secondarymarket.bean.Response;
import com.zq.secondarymarket.entity.User;
import com.zq.secondarymarket.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService iUserService;

    @RequestMapping("/test")
    public Response getAllUserList() {
        Response response = new Response();
        List<User>  list = iUserService.getAllUserList();
        response.setResultMessage("返回用户数据成功!");
        response.setResultCode("200");
        response.setBeans(list);
        return response;
    }
}
