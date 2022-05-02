package com.zq.secondarymarket.entity;

import lombok.Data;

@Data
public class User {
    private String userId;  // 用户id
    private String userName; // 用户名
    private String password; // 密码
    private String grade; // 用户年级
    private String phone;   // 手机号
    private String userType; // 用户类型
    private String sex; //  性别
    private String qq;  //  QQ号码
    private String description; // 描述
    private String goodType; // 商品类型
    private String receiveAddress; //  收货地址
    private String nowAddress; //  现在地址
}
