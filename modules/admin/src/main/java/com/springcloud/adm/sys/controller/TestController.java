package com.springcloud.adm.sys.controller;

/**
 * @description:
 * @author: szmiao
 * @date: 2019/9/28 11:00
 */

import com.springcloud.adm.config.utils.ShiroUtils;
import com.springcloud.common.result.ResultApi;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "test")
public class TestController {

    @GetMapping("info")
    public ResultApi info() {
        return ResultApi.ok().put("user", ShiroUtils.getUserEntity());
    }
}
