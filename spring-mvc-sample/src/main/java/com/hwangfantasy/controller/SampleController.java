package com.hwangfantasy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @作者 yunfeiyang
 * @创建时间: 2017/4/12 <br/>
 * @方法描述: TODO ADD FUNCTION. <br/>
 */
@Controller
@RequestMapping("/sample")
public class SampleController {

    @RequestMapping("/sayHi")
    @ResponseBody
    public String sayHi(){
        return "Hello Fantasy!";
    }
}
