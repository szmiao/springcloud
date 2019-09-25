package com.adm.sys.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 系统用户Token
 */
@Data
public class TAdmSysUserTokenEntity {
	private Long userId;
	private String token;
	private Date expireTime;
	private Date updateTime;
}
