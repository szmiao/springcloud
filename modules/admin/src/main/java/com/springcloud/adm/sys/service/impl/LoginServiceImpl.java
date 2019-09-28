package com.springcloud.adm.sys.service.impl;

import com.springcloud.adm.sys.bo.RegisterBO;
import com.springcloud.adm.sys.dao.TAdmSysUserDao;
import com.springcloud.adm.sys.entity.TAdmSysUserEntity;
import com.springcloud.adm.sys.service.UserTokenService;
import com.springcloud.adm.sys.service.LoginService;
import com.springcloud.common.result.ResultApi;
import com.springcloud.common.utils.MachUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: szmiao
 * @date: 2019/9/25 16:46
 */
@Service("loginService")
@Slf4j
public class LoginServiceImpl implements LoginService {
    @Autowired
    private TAdmSysUserDao admSysUserDao;
    @Autowired
    private UserTokenService userTokenService;

    @Override
    public ResultApi login(String name, String password) {
        // 用户信息
        TAdmSysUserEntity user = admSysUserDao.queryByName(name);
        // 账号不存在、密码错误
        if (user == null || !user.getPassword().equals(new Sha256Hash(password, user.getSalt()).toHex())) {
            log.error("账号或密码不正确,inputPassword:{},realUser:{}",password, user);
            return ResultApi.error("账号或密码不正确");
        }
        // 账号锁定
        if (user.getStatus() == 0) {
            return ResultApi.error("账号已停用");
        }
        // 生成token，并保存到数据库
        ResultApi r = userTokenService.createToken(user.getId());
        return r;
    }

    @Override
    public ResultApi register(RegisterBO registerBO) {
        String username = registerBO.getUsername();
        TAdmSysUserEntity userEntity = admSysUserDao.queryByName(username);
        if(null != userEntity && username.equals(userEntity.getUsername())){
            return ResultApi.error("该用户名已存在！");
        }
        userEntity = new TAdmSysUserEntity();
        BeanUtils.copyProperties(registerBO, userEntity);
        userEntity.setSalt(MachUtil.createRandomStringData(6));
        userEntity.setPassword(new Sha256Hash(registerBO.getPassword(), userEntity.getSalt()).toHex());
        admSysUserDao.save(userEntity);
        return ResultApi.ok();
    }
}
