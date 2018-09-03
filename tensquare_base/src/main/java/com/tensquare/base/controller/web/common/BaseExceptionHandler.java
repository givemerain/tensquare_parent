package com.tensquare.base.controller.web.common;

import constants.StatusCode;
import dto.ResultDTO;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author ye jiacheng
 * @create 2018-08-30
 * 全局异常处理类(通知类)
 * @ControllerAdvice
 * 组合注解，相当于@ControllerAdvice+@ResponseBody
 */
@RestControllerAdvice
public class BaseExceptionHandler {

    //增强的方法：异常通知处理
    //当有异常的情况下自动该方法处理异常的注解
    //如果为空，则自动抓取参数中的异常列表
    @ExceptionHandler
    public ResultDTO error(Exception e) {

        e.printStackTrace();
        return new ResultDTO(false, StatusCode.ERROR,e.getMessage());
    }


}
