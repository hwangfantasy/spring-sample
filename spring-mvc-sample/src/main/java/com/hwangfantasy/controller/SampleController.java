package com.hwangfantasy.controller;

import com.hwangfantasy.bean.User;
import com.hwangfantasy.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @作者 yunfeiyang
 * @创建时间: 2017/4/12 <br/>
 * @方法描述: TODO ADD FUNCTION. <br/>
 */
@Controller
@RequestMapping("/sample")
public class SampleController {
    @Autowired
    private SampleService sampleService;

    @RequestMapping("/sayHi")
    @ResponseBody
    public String sayHi(){
        return "Hello Fantasy!";
    }

    @RequestMapping("/addUser")
    @ResponseBody
    public String addUser(@RequestParam String name,@RequestParam String password,@RequestParam String phone){
        User user = new User();
        sampleService.addUser(user.withName(name).withPassword(password).withPhone(phone));
        return "success";
    }
}
