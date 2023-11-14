package com.wait.sellsystem.service;

import com.wait.sellsystem.domain.dto.login.LoginDTO;
import com.wait.sellsystem.domain.param.login.LoginParam;
import com.wait.sellsystem.domain.param.login.RegisterParam;

/**
 * @author 天
 * Time: 2023/11/15 3:51
 */
public interface LoginService {

    /**
     * 登录
     * @param loginParam
     * @return
     */
    LoginDTO login(LoginParam loginParam);

    /**
     * 注册
     * @param registerParam
     * @return
     */
    int register(RegisterParam registerParam);
}
