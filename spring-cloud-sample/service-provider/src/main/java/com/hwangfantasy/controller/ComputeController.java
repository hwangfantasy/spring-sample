package com.hwangfantasy.controller;

import com.hwangfantasy.ComputeInterface;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @作者 hwangfantasy
 * @创建时间: 2017/4/10 <br/>
 * @方法描述: 样例计算服务. <br/>
 */
@RefreshScope
@RestController
public class ComputeController implements ComputeInterface{
    @Value("${name}")
    private String name;


    @RequestMapping(value = "/sayHi")
    public String sayHi(){
        return this.name;
    }

    @Override
    public Integer add(Integer a, Integer b) {
        return a+b;
    }
}
