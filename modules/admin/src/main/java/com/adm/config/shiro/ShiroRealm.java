package com.adm.config.shiro;

import com.adm.sys.dto.LoginUserDTO;
import com.adm.sys.entity.TAdmSysUserTokenEntity;
import com.adm.sys.entity.TAdmSysUserEntity;
import com.adm.sys.enums.UserStatusEnum;
import com.adm.sys.service.ShiroService;
import com.common.message.MessageCodeSystem;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @description:
 * @author: szmiao
 * @date: 2019/9/23 16:55
 */
public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    private ShiroService shiroService;

    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        LoginUserDTO loginUserDTO = (LoginUserDTO) principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        return info;
    }

    /**
     * 认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String accessToken = (String) authenticationToken.getPrincipal();
        TAdmSysUserTokenEntity userTokenEntity = shiroService.queryByToken(accessToken);
        if(userTokenEntity == null || userTokenEntity.getExpireTime().getTime() < System.currentTimeMillis()){
            throw new IncorrectCredentialsException(MessageCodeSystem.TOKEN_HAS_EXPIRED.getText());
        }
        TAdmSysUserEntity user = shiroService.queryUser(userTokenEntity.getUserId());
        //账号锁定
        if(!UserStatusEnum.NORMAL.getValue().equals(user.getStatus())){
            throw new LockedAccountException(MessageCodeSystem.ACCOUNT_HAS_BEEN_LOCKED.getText());
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, accessToken, getName());
        return info;
    }
}
