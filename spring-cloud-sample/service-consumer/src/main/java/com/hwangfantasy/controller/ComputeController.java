package com.hwangfantasy.controller;

import com.hwangfantasy.service.ComputeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @作者 hwangfantasy
 * @创建时间: 2017/4/10 <br/>
 * @方法描述: 样例计算服务消费. <br/>
 */
@RestController
@RequestMapping(value = "/compute")
public class ComputeController {

    @Autowired
    ComputeService computeService;
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add() {
        return computeService.addService();
    }
}
