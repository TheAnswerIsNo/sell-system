package com.wait.sellsystem.service.impl;

import cn.dev33.satoken.exception.SaTokenException;
import cn.dev33.satoken.secure.BCrypt;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.wait.sellsystem.dao.UserMapper;
import com.wait.sellsystem.domain.dto.login.LoginDTO;
import com.wait.sellsystem.domain.entity.User;
import com.wait.sellsystem.domain.enumerattion.PrefixEnum;
import com.wait.sellsystem.domain.param.login.LoginParam;
import com.wait.sellsystem.domain.param.login.RegisterParam;
import com.wait.sellsystem.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Objects;

/**
 *
 * @author 天
 * Time: 2023/11/15 3:51
 */
@Service
public class LoginServiceImpl implements LoginService {

    private final UserMapper userMapper;

    @Autowired
    public LoginServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public LoginDTO login(LoginParam loginParam) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUsername,loginParam.getUsername());
        User user = userMapper.selectOne(queryWrapper);
        if (Objects.isNull(user)){
            throw new SaTokenException(400,"该账号不存在");
        }

        if (!BCrypt.checkpw(loginParam.getPassword(), user.getPassword())) {
            throw new SaTokenException(400, "密码错误");
        }

        String loginId = PrefixEnum.USER.getValue() + user.getId();
        StpUtil.login(loginId);


        return BeanUtil.copyProperties(user, LoginDTO.class);
    }

    @Override
    public int register(RegisterParam registerParam) {
        User user = BeanUtil.copyProperties(registerParam, User.class);
        String encryptPw = BCrypt.hashpw(registerParam.getPassword());
        user.setPassword(encryptPw);
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
