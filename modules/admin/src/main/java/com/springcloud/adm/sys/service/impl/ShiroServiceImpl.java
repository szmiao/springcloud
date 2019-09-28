package com.springcloud.adm.sys.service.impl;

import com.springcloud.adm.sys.dao.TAdmSysUserDao;
import com.springcloud.adm.sys.dao.TAdmSysUserTokenDao;
import com.springcloud.adm.sys.dto.LoginUserDTO;
import com.springcloud.adm.sys.entity.TAdmSysUserTokenEntity;
import com.springcloud.adm.sys.service.ShiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: szmiao
 * @date: 2019/9/23 17:44
 */
@Service("shiroService")
public class ShiroServiceImpl implements ShiroService {
    @Autowired
    private TAdmSysUserTokenDao userTokenDao;
    @Autowired
    private TAdmSysUserDao userDao;

    @Override
    public TAdmSysUserTokenEntity queryByToken(String accessToken) {
        return userTokenDao.queryByToken(accessToken);
    }

    @Override
    public LoginUserDTO queryUser(Long userId) {
        return userDao.queryUser(userId);
    }
}
