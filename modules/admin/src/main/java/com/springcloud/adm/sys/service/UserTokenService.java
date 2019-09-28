package com.springcloud.adm.sys.service;

import com.springcloud.common.result.ResultApi;

public interface UserTokenService {
    ResultApi createToken(Long userId);
}
