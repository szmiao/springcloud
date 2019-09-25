package com.adm.sys.controller;

import com.adm.sys.bo.LoginBO;
import com.adm.sys.service.LoginService;
import com.common.result.ResultApi;
import com.common.validator.ValidationUtils;
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
        return loginService.login(loginBO.getName(), loginBO.getPassword());
    }
}
