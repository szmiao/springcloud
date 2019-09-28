package com.springcloud.adm.sys.service;

import com.springcloud.adm.sys.bo.RegisterBO;
import com.springcloud.common.result.ResultApi;

public interface LoginService {
    ResultApi login(String name, String password);

    ResultApi register(RegisterBO registerBO);
}
