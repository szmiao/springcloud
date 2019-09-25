package com.adm.sys.service;

import com.common.result.ResultApi;

public interface LoginService {
    ResultApi login(String name, String password);
}
