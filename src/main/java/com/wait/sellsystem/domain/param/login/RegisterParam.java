package com.wait.sellsystem.domain.param.login;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author 天
 * Time: 2023/11/15 4:14
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterParam {

    private String username;

    private String password;

    private String name;

    private String telephone;
}
