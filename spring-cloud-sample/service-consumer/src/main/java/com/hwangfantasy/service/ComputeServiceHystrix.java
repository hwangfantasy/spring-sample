package com.hwangfantasy.service;

import com.hwangfantasy.common.AddBean;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
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

    @Override
    public Integer addBean(@RequestBody AddBean addBean) {
        return 9999;
    }
}
