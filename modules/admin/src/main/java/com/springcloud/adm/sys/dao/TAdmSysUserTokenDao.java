package com.springcloud.adm.sys.dao;


import com.springcloud.adm.sys.entity.TAdmSysUserTokenEntity;
import com.springcloud.common.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TAdmSysUserTokenDao extends BaseDao<TAdmSysUserTokenEntity> {

    TAdmSysUserTokenEntity queryByToken(@Param("accessToken") String accessToken);

    TAdmSysUserTokenEntity queryByUserId(@Param("userId") Long userId);
}
