package com.adm.sys.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum UserStatusEnum {
    PROHIBIT(0, "禁用"),
    NORMAL(1, "正常")
    ;

    private Integer value;
    private String text;
}
