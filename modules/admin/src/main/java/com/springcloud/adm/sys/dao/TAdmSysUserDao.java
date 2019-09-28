package com.springcloud.adm.sys.dao;


import com.springcloud.adm.sys.dto.LoginUserDTO;
import com.springcloud.adm.sys.entity.TAdmSysUserEntity;
import com.springcloud.common.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TAdmSysUserDao extends BaseDao<TAdmSysUserEntity> {

    LoginUserDTO queryUser(@Param("userId") Long userId);

    TAdmSysUserEntity queryByName(@Param("name") String name);
}
