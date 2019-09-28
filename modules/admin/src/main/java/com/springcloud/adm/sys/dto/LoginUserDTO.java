package com.springcloud.adm.sys.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @description:
 * @author: szmiao
 * @date: 2019/9/24 17:00
 */
@Data
public class LoginUserDTO implements Serializable {
    private static final long serialVersionUID = 4293644469286791299L;
    private Long userId;
    private String username;
    private String token;
    private Date expireTime;
    private Integer status;
}
