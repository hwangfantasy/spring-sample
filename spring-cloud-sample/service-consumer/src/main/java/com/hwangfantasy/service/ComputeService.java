package com.hwangfantasy.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @作者 yunfeiyang
 * @创建时间: 2017/4/26 <br/>
 * @方法描述: ComputeInterface. <br/>
 */
@FeignClient(value = "service-provider",fallback = ComputeServiceHystrix.class)
public interface ComputeService {

    @RequestMapping(method = RequestMethod.GET, value = "/compute/add")
    Integer add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b);

}
