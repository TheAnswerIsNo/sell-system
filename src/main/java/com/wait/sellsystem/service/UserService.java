package com.wait.sellsystem.service;

import com.wait.sellsystem.domain.entity.User;

/**
 * @author 天
 * Time: 2023/11/16 3:14
 */
public interface UserService {

    /**
     * 根据账号查询
     * @param username
     * @return
     */
    User findByUsername(String username);

    /**
     * 添加用户
     * @param user
     * @return
     */
    int insert(User user);
}
