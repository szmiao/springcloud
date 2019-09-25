package com.adm.sys.service.impl;

import com.adm.sys.dao.TAdmSysUserTokenDao;
import com.adm.sys.dao.TAdmSysUserDao;
import com.adm.sys.entity.TAdmSysUserTokenEntity;
import com.adm.sys.entity.TAdmSysUserEntity;
import com.adm.sys.service.ShiroService;
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
    public TAdmSysUserEntity queryUser(Long userId) {
        return userDao.queryUser(userId);
    }
}
