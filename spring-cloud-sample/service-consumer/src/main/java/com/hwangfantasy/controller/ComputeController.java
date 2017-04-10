package com.hwangfantasy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @作者 yunfeiyang
 * @创建时间: 2017/4/10 <br/>
 * @方法描述: 样例计算服务消费. <br/>
 */
@RestController
@RequestMapping(value = "/compute")
public class ComputeController {

    @Autowired
    RestTemplate restTemplate;
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add() {
        return restTemplate.getForEntity("http://SERVICE-PROVIDER-COMPUTE/compute/add?a=10&b=20", String.class).getBody();
    }
}
