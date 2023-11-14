package com.wait.sellsystem.controller;

import cn.dev33.satoken.util.SaResult;
import com.wait.sellsystem.domain.dto.login.LoginDTO;
import com.wait.sellsystem.domain.param.login.LoginParam;
import com.wait.sellsystem.domain.param.login.RegisterParam;
import com.wait.sellsystem.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 天
 * Time: 2023/11/15 3:50
 */
@RestController
@RequestMapping(value = "/user")
@Api(tags = "登录")
public class LoginController {

    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @ApiOperation("登录")
    @RequestMapping("/login")
    public SaResult login(@RequestBody LoginParam loginParam){
        LoginDTO loginDTO = loginService.login(loginParam);
        return new SaResult(SaResult.CODE_SUCCESS,"登录成功",loginDTO);
    }

    @ApiOperation("注册")
    @RequestMapping("/register")
    public SaResult register(@RequestBody RegisterParam registerParam){
        int result = loginService.register(registerParam);
        if (result > 0){
            return SaResult.ok("注册成功");
        }
        return SaResult.error("注册失败");
    }


}
