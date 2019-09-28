package com.springcloud.adm.sys.bo;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @description:
 * @author: szmiao
 * @date: 2019/9/27 17:43
 */
@Data
public class RegisterBO {
    @NotBlank(message = "请输入账号")
    private String username;
    @NotBlank(message = "请输入姓名")
    private String realName;
    @NotBlank(message = "请输入密码")
    private String password;
    @NotBlank(message = "请输入手机号")
    private String mobile;
}
