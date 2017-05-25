package com.hwangfantasy.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @作者 yunfeiyang
 * @创建时间: 2017/5/25 <br/>
 * @方法描述: ExceptionHandler. <br/>
 */
@ControllerAdvice
public class SampleExceptionHandler {
    //所有抛出UnLoginException的地方都会被这个方法处理
    @ExceptionHandler(value = UnLoginException.class)
    public String unLoginExceptionHandler(){
        return "unlogin";
    }
}
