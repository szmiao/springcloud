package com.adm.sys.service;

import com.common.result.ResultApi;

public interface UserTokenService {
    ResultApi createToken(Long userId);
}
