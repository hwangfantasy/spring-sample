package com.hwangfantasy.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MarkerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @作者 hwangfantasy
 * @创建时间: 2017/4/13 <br/>
 * @方法描述: ScheduledTask. <br/>
 */
@Component
public class ScheduledTask {
    private static final Logger LOGGER = LoggerFactory.getLogger(ScheduledTask.class);

    //    @Scheduled(cron = "0 0 0 * * ?")//每天0点启动
    @Scheduled(fixedRate = 1000 * 60 * 5)//每5分钟启动一次
    private void sayHello() {
        LOGGER.info(MarkerFactory.getMarker("NOTIFY_ADMIN"),"Hello World!");
        LOGGER.error(MarkerFactory.getMarker("NOTIFY_ADMIN"),"Hello World!");
    }
}
