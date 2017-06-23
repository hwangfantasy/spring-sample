package com.hwangfantasy.controller;

import com.hwangfantasy.bean.User;
import com.hwangfantasy.config.redis.RedisService;
import com.hwangfantasy.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @作者 hwangfantasy
 * @创建时间: 2017/4/25 <br/>
 * @方法描述: SampleController. <br/>
 */
@Controller
@RequestMapping("/sample")
public class SampleController {
    @Autowired
    private SampleService sampleService;

    @Autowired
    private RedisService redisService;

    @RequestMapping(value = "/getUser")
    @ResponseBody
    public Object getUser(@RequestParam String name) {
        User user = sampleService.getUserByName(name);
        if (user != null) {
            return user;
        } else {
            return "can not find name:" + name;
        }
    }

    @RequestMapping(value = "/addRedis")
    @ResponseBody
    public Object addRedis(@RequestParam String key,@RequestParam String value) {
        boolean isSuccess = redisService.set(key,value);
        return isSuccess ? "success" : "failure";
    }

    @RequestMapping(value = "/showPage")
    public String page(){
        return "page";
    }
}
