package com.springcloud.adm.sys.entity;

import lombok.Data;

import java.util.Date;


/**
 * 系统用户Token
 * @author szmia
 */
@Data
public class TAdmSysUserTokenEntity{
	private Long userId;
	private String token;
	private Date expireTime;
	private Date updateTime;
}
