package com.wait.sellsystem.domain.param.login;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author 天
 * Time: 2023/11/15 4:02
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginParam {

    private String username;

    private String password;
}
