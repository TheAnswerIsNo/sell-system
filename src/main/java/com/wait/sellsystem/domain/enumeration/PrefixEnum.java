package com.wait.sellsystem.domain.enumeration;

import lombok.Getter;

/**
 * @author 天
 * @description: 前缀枚举
 */
@Getter
public enum PrefixEnum {

    USER("用户前缀", "userId-");


    private final String name;

    private final String value;

    PrefixEnum(String name, String value) {
        this.name = name;
        this.value = value;
    }
}
