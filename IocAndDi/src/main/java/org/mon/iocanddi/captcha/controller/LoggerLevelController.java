package org.mon.iocanddi.captcha.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/logger")
public class LoggerLevelController {
    private static Logger logger = LoggerFactory.getLogger(LoggerLevelController.class);

    @RequestMapping("/print")
    public String print(){
//        默认的日志级别是info，低于info级别是不会被打印出来的
        logger.trace("trace级别日志......");
        logger.debug("debug级别日志......");
        logger.info("info级别日志......");
        logger.warn("warn级别日志......");
        logger.error("error级别日志......");
        return "打印日志";
    }
}
