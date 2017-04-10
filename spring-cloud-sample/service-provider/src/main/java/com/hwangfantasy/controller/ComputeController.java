package com.hwangfantasy.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @作者 yunfeiyang
 * @创建时间: 2017/4/10 <br/>
 * @方法描述: 样例计算服务. <br/>
 */

@RestController
@RequestMapping(value = "/compute")
public class ComputeController {

    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public Integer add(@RequestParam Integer a,@RequestParam Integer b){
        return a+b;
    }
}
