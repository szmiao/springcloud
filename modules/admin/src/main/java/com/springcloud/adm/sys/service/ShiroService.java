package com.springcloud.adm.sys.service;

import com.springcloud.adm.sys.dto.LoginUserDTO;
import com.springcloud.adm.sys.entity.TAdmSysUserTokenEntity;

/**
 * @description:
 * @author: szmiao
 * @date: 2019/9/23 17:44
 */
public interface ShiroService {
    TAdmSysUserTokenEntity queryByToken(String accessToken);

    LoginUserDTO queryUser(Long userId);
}
