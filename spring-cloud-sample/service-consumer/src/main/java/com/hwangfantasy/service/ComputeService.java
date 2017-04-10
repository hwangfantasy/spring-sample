package com.hwangfantasy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * @作者 hwangfantasy
 * @创建时间: 2017/4/10 <br/>
 * @方法描述: 样例消费服务. <br/>
 */
@Service
public class ComputeService {
    private static final String service_provider_id = "SERVICE-PROVIDER";
    @Autowired
    RestTemplate restTemplate;
    @HystrixCommand(fallbackMethod = "addServiceFallback")
    public String addService(Integer a,Integer b) {
        return restTemplate.getForEntity("http://"+service_provider_id+"/compute/add?a="+a+"&b="+b, String.class).getBody();
    }
    public String addServiceFallback() {
        return "error";
    }
}
