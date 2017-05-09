package com.hwangfantasy.annotation;

import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.annotation.*;

/**
 * @作者 yunfeiyang
 * @创建时间: 2017/5/9 <br/>
 * @方法描述: SampleController. <br/>
 */
@Target(ElementType.TYPE)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@RequestMapping("/sample")
@Documented
public @interface SampleControllerAnnotation {
    String name() default "";
}
