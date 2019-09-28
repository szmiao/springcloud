package com.springcloud.common.result;

import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: szmiao
 * @date: 2019/9/25 16:01
 */
public class ResultApi extends HashMap<String, Object> {

    public static final int SUCCESS = 200;

    public ResultApi() {
        put("status", 200);
        put("message", "操作成功");
    }

    public static ResultApi error() {
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, "未知异常，请联系管理员");
    }

    public static ResultApi error(String message) {
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, message);
    }

    public static ResultApi error(int status, String message) {
        ResultApi r = new ResultApi();
        r.put("status", status);
        r.put("message", message);
        return r;
    }

    public static ResultApi ok(String message) {
        ResultApi r = new ResultApi();
        r.put("message", message);
        return r;
    }

    public static ResultApi ok(Map<String, Object> map) {
        ResultApi r = new ResultApi();
        r.putAll(map);
        return r;
    }

    public static ResultApi ok() {
        return new ResultApi();
    }

    @Override
    public ResultApi put(String key, Object value) {
        super.put(key, value);
        return this;
    }

    public Integer getStatus (){
        return (Integer)this.get("status");
    }

    public String getMessage (){
        return (String)this.get("Message");
    }
}
