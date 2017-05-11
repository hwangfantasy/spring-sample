package com.hwangfantasy.service;

import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * @作者 hwangfantasy
 * @创建时间: 2017/4/26 <br/>
 * @方法描述: ComputeInterface. <br/>
 */
@FeignClient(value = "service-provider",fallback = ComputeServiceHystrix.class)
public interface ComputeService extends ComputeInterface {



}
