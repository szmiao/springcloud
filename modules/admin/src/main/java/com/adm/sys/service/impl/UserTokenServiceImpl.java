package com.adm.sys.service.impl;

import com.adm.config.oauth2.TokenGenerator;
import com.adm.sys.dao.TAdmSysUserTokenDao;
import com.adm.sys.entity.TAdmSysUserTokenEntity;
import com.adm.sys.service.UserTokenService;
import com.common.result.ResultApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @description:
 * @author: szmiao
 * @date: 2019/9/25 17:46
 */
@Service("userTokenService")
public class UserTokenServiceImpl implements UserTokenService {
    @Autowired
    private TAdmSysUserTokenDao admSysUserTokenDao;
    // 12小时后过期
    private final static int EXPIRE = 3600 * 12;

    @Override
    public ResultApi createToken(Long userId) {
        // 生成一个token
        String token = TokenGenerator.generateValue();
        // 当前时间
        Date now = new Date();
        // 过期时间
        Date expireTime = new Date(now.getTime() + EXPIRE * 1000);
        //判断是否生成过token
        TAdmSysUserTokenEntity tokenEntity = admSysUserTokenDao.queryByUserId(userId);
        if(tokenEntity == null){
            tokenEntity = new TAdmSysUserTokenEntity();
            tokenEntity.setUserId(userId);
            tokenEntity.setToken(token);
            tokenEntity.setExpireTime(expireTime);
            //保存token
            admSysUserTokenDao.save(tokenEntity);
        }else{
            tokenEntity.setToken(token);
            tokenEntity.setExpireTime(expireTime);
            //更新token
            admSysUserTokenDao.update(tokenEntity);
        }
        return ResultApi.ok().put("token", token).put("expire", EXPIRE);
    }
}
