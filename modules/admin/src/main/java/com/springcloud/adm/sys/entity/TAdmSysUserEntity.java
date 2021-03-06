package com.springcloud.adm.sys.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author szmia
 */
@Data
public class TAdmSysUserEntity{
    private Long id;
    private String username;
    private String realName;
    private String password;
    private String salt;
    private String mobile;
    private Integer status;
    private Date createTime;
    private Date updateTime;
}
