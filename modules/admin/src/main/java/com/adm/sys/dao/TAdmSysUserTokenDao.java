package com.adm.sys.dao;


import com.adm.sys.entity.TAdmSysUserTokenEntity;
import com.common.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TAdmSysUserTokenDao extends BaseDao<TAdmSysUserTokenEntity> {

    TAdmSysUserTokenEntity queryByToken(@Param("accessToken") String accessToken);

    TAdmSysUserTokenEntity queryByUserId(@Param("userId") Long userId);
}
