package com.hwangfantasy.controller;

import com.hwangfantasy.service.ComputeService;
//import com.hwangfantasy.service.ComputeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @作者 hwangfantasy
 * @创建时间: 2017/4/10 <br/>
 * @方法描述: 样例计算服务消费. <br/>
 */
@RefreshScope
@RestController
@RequestMapping(value = "/compute")
public class ComputeController {
    @Value("${name}")
    private String name;

    @Autowired
    ComputeService computeService;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(@RequestParam Integer a, @RequestParam Integer b) {
        return String.valueOf(computeService.add(a,b));
    }

    @RequestMapping(value = "sayHi")
    public String sayHi(){
        return this.name;
    }
}
