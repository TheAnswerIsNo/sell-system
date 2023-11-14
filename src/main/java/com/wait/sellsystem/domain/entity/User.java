package com.wait.sellsystem.domain.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* 用户表
* @TableName user
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("user")
public class User{

    /**
    * 用户ID
    */
    @TableId(type = IdType.ASSIGN_ID)
    private String id;

    /**
    * 账号
    */
    private String username;

    /**
    * 密码
    */
    private String password;

    /**
    * 姓名
    */
    private String name;

    /**
    * 手机号
    */
    private String telephone;
}
