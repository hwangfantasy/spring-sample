package com.hwangfantasy.service;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @作者 hwangfantasy
 * @创建时间: 2017/4/26 <br/>
 * @方法描述: ComputeClientHystrix. <br/>
 */
@Component
public class ComputeServiceHystrix implements ComputeService {
    @Override
    public Integer add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b){
        return 9999;
    }
}
