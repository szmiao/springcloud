package com.springcloud.ordinaryuser.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * program: springcloud
 * description:
 * author: szmiao
 * version V1.0.0
 * create: 2019-04-26 14:04:12
 **/
@RestController
@RequestMapping(value = "sys/")
public class LoginController {

    @PostMapping(value = "login")
    public String login() {
        return "ssss";
    }
}
