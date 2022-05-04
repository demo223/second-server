package com.zq.secondarymarket.mapper;

import com.zq.secondarymarket.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface UserMapper {
    /**
     * 查询所有的用户
     * @return
     */
    List<User> getAllUserList();

    /**
     * 判断账号密码是否正确
     * @param userId
     * @param password
     * @return 
     */
    List<User> allowLogin(@Param("userId") String userId, @Param("password") String password);

    /**
     * 根据用户id查询用户信息
     * @param userId
     * @return
     */
    User getUserById(@Param("userId") String userId);

    /**
     * 注册用户
     * @param user
     * @return
     */
    int registerUser(User user);

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    int updateUser(User user);

    /**
     * 根据用户id删除用户
     * @param userId
     * @return
     */
    int deleteUserById(@Param("userId") String userId);

    /**
     * 分页获取用户数据
     * @param map
     * @return
     */
    List<User> getUserListByPage (Map<String, Object> map);
    // 获取分页数据总数
    int getUserCount(@Param("grade") String grade, @Param("searchValue") String searchValue, @Param("userType") String userType);
}
