package org.mon.iocanddi.captcha.facade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LivingRoomLight implements Light {

    private static Logger logger= LoggerFactory.getLogger(LivingRoomLight.class);

    @Override
    public void on() {
        logger.info("打开客厅的灯");
//        System.out.println("打开客厅的灯");
    }

    @Override
    public void off() {
        logger.info("关闭客厅灯");
//        System.out.println("关闭客厅灯");
    }
}
