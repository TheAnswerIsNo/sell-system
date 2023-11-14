package com.wait.sellsystem.domain.dto.login;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author 天
 * Time: 2023/11/15 4:11
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginDTO {

    private String id;

    private String username;

    private String name;

    private String telephone;
}
