package com.adm.sys.service;

import com.adm.sys.entity.TAdmSysUserTokenEntity;
import com.adm.sys.entity.TAdmSysUserEntity;

/**
 * @description:
 * @author: szmiao
 * @date: 2019/9/23 17:44
 */
public interface ShiroService {
    TAdmSysUserTokenEntity queryByToken(String accessToken);

    TAdmSysUserEntity queryUser(Long userId);
}
