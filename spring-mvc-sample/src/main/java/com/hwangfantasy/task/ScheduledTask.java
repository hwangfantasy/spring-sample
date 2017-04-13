package com.hwangfantasy.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @作者 yunfeiyang
 * @创建时间: 2017/4/13 <br/>
 * @方法描述: TODO ADD FUNCTION. <br/>
 */
@Component
public class ScheduledTask {
    private static final Logger LOGGER = LoggerFactory.getLogger(ScheduledTask.class);

    //    @Scheduled(cron = "0 0 0 * * ?")//每天0点启动
    @Scheduled(fixedRate = 1000 * 60 * 5)//每5分钟启动一次
    private void sayHello() {
        LOGGER.info("Hello World!");
        System.out.print("Hello World!");
    }
}
