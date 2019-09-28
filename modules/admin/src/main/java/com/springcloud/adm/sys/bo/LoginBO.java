package com.springcloud.adm.sys.bo;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @description:
 * @author: szmiao
 * @date: 2019/9/25 16:55
 */
@Data
public class LoginBO {
    @NotBlank(message = "请输入用户名")
    private String username;
    @NotBlank(message = "请输入密码")
    private String password;
}
