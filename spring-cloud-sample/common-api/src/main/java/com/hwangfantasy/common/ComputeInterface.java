package com.hwangfantasy.common;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @作者 yunfeiyang
 * @创建时间: 2017/5/11 <br/>
 * @方法描述: ComputeInterface. <br/>
 */

public interface ComputeInterface {
    @RequestMapping(method = RequestMethod.GET, value = "/compute/add")
    Integer add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b);
}
