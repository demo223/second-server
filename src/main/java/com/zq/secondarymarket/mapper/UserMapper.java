package com.zq.secondarymarket.mapper;

import com.zq.secondarymarket.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    /**
     * 查询所有的用户
     * @return
     */
    List<User> getAllUserList();
}
