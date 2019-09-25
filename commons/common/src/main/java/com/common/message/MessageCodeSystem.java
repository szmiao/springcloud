package com.common.message;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum MessageCodeSystem {
    TOKEN_HAS_EXPIRED(401, "token失效，请重新登录!"),
    ACCOUNT_HAS_BEEN_LOCKED(401, "账号已被锁定,请联系管理员!"),

    ;
    private Integer value;
    private String text;
}
