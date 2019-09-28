package com.springcloud.adm.sys.controller;

import com.springcloud.adm.sys.bo.LoginBO;
import com.springcloud.adm.sys.bo.RegisterBO;
import com.springcloud.adm.sys.service.LoginService;
import com.springcloud.common.result.ResultApi;
import com.springcloud.common.validator.ValidationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: szmiao
 * @date: 2019/9/18 11:50
 */
@RestController
@RequestMapping(value = "sys")
public class SysLoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping(value = "login")
    public ResultApi login(LoginBO loginBO) {
        ValidationUtils.validate(loginBO);
        return loginService.login(loginBO.getUsername(), loginBO.getPassword());
    }

    @PostMapping(value = "register")
    public ResultApi register(RegisterBO registerBO) {
        ValidationUtils.validate(registerBO);
        return loginService.register(registerBO);
    }
}
