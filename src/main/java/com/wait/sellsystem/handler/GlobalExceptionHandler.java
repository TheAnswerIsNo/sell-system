package com.wait.sellsystem.handler;

import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.exception.NotPermissionException;
import cn.dev33.satoken.exception.SaTokenException;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import com.wait.sellsystem.exception.CommonErrorEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author 天
 * @description: 全局异常处理器
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 未知异常或线程池异常
     */
    @ExceptionHandler(value = Exception.class)
    public SaResult handlerException(Exception e) {
        log.error("system exception! userId: {} The reason is: {}", StpUtil.getLoginId().toString(), e.getMessage(), e);
        e.printStackTrace();
        return SaResult.error(CommonErrorEnum.SYSTEM_ERROR.getMsg());
    }

    /**
     * 未登录异常
     */
    @ExceptionHandler(value = NotLoginException.class)
    public SaResult handlerNotLoginException(NotLoginException e) {
        log.error("not login exception! The reason is: {}", e.getMessage(), e);
        return new SaResult(e.getCode(), e.getMessage().split("：")[0], null);
    }

    /**
     * 空指针异常
     */
    @ExceptionHandler(value = NullPointerException.class)
    public SaResult handlerNullPointerException(NullPointerException e) {
        log.error("null point exception！The reason is: {}", e.getMessage(),e);
        return SaResult.error(CommonErrorEnum.SYSTEM_ERROR.getMsg());
    }

    /**
     * 业务异常
     */
    @ExceptionHandler(value = SaTokenException.class)
    public SaResult handlerSaTokenException(SaTokenException e) {
        return new SaResult(e.getCode(),e.getMessage(),null);
    }

    /**
     * 权限异常
     */
    @ExceptionHandler(value = NotPermissionException.class)
    public SaResult handlerNotPermissionException(NotPermissionException e){
        log.error("noy permission exception！The reason is: {}", e.getMessage(),e);
        return new SaResult(CommonErrorEnum.PERMISSION_ERROR.getCode(),e.getMessage(),null);
    }
}