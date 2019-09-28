package com.springcloud.common.handler;

import com.springcloud.common.exception.RRException;
import com.springcloud.common.message.MessageCodeSystem;
import com.springcloud.common.result.ResultApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResultApi otherExceptionHandler(HttpServletResponse response, Exception ex) {
        response.setStatus(500);
        log.warn("otherExceptionHandler,response:{},ex:{},status:500",ex.getMessage(),ex);
        return ResultApi.error(MessageCodeSystem.EX_OTHER_MSG.getValue(), MessageCodeSystem.EX_OTHER_MSG.getText());
    }

    /**
     * 自定义异常
     */
    @ExceptionHandler(RRException.class)
    public ResultApi handleRRException(RRException e){
        e.printStackTrace();
        ResultApi r = new ResultApi();
        r.put("status", e.getStatus());
        r.put("message", e.getMessage());
        return r;
    }

    @ExceptionHandler(DuplicateKeyException.class)
    public ResultApi handleDuplicateKeyException(DuplicateKeyException e){
        log.error(e.getMessage(), e);
        return ResultApi.error("数据库中已存在该记录");
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultApi handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
        log.error(e.getMessage(), e);
        StringBuilder stringBuilder = new StringBuilder();
        for (ObjectError error : e.getBindingResult().getAllErrors()) {
            stringBuilder.append("[").append(error.getDefaultMessage()).append("] ");
        }
        return ResultApi.error(stringBuilder.toString());
    }
}
