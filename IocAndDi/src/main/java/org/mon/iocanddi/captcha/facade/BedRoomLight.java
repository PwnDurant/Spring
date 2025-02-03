package org.mon.iocanddi.captcha.facade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BedRoomLight implements Light {

    private static Logger logger= LoggerFactory.getLogger(BedRoomLight.class);

    public BedRoomLight() {
        super();
    }

    @Override
    public void on() {
        logger.info("打开卧室的灯");
//        System.out.println("打开卧室的灯");
    }

    @Override
    public void off() {
        logger.info("关闭卧室灯");
//        System.out.println("关闭卧室灯");
    }
}
