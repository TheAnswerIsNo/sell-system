package com.wait.sellsystem.service.impl;

import cn.dev33.satoken.exception.SaTokenException;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.wait.sellsystem.dao.UserMapper;
import com.wait.sellsystem.domain.entity.User;
import com.wait.sellsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLIntegrityConstraintViolationException;

/**
 * @author 天
 * Time: 2023/11/16 3:14
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User findByUsername(String username) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUsername,username);
        return userMapper.selectOne(queryWrapper);
    }

    @Override
    public int insert(User user) {
        int result = 0;
        try {
            result = userMapper.insert(user);
        } catch (Exception e) {
            if (e.getCause() instanceof SQLIntegrityConstraintViolationException){
                throw new SaTokenException(400,"该账户已存在");
            }
        }
        return result;
    }
}
