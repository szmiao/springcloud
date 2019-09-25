package com.adm.sys.dao;


import com.adm.sys.entity.TAdmSysUserEntity;
import com.common.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TAdmSysUserDao extends BaseDao<TAdmSysUserEntity> {

    TAdmSysUserEntity queryUser(@Param("userId") Long userId);

    TAdmSysUserEntity queryByName(@Param("name") String name);
}
