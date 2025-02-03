package org.mon.iocanddi.captcha.controller;


import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.Data;
import org.apache.coyote.http2.HpackDecoder;
import org.mon.iocanddi.captcha.model.CaptchaProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.Date;

@RequestMapping("/captcha")
@RestController
public class CaptchaController {

//    打印日志
    private static Logger logger= LoggerFactory.getLogger(CaptchaController.class);


    @Autowired
    private CaptchaProperties captchaProperties;
//    一分钟
    private static long VALID_TIME_OUT=60*1000;


    @GetMapping("/getCaptcha")
    public void getCaptcha(HttpServletResponse response, HttpSession session) throws IOException {
//        生成验证码
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(captchaProperties.getWidth(), captchaProperties.getHeight());
//        打印验证码
        String code=lineCaptcha.getCode();
        System.out.println(code);
        logger.info("Logger:生成验证码"+code);
//        存储session
        session.setAttribute(captchaProperties.getSession().getKey(),code);
        session.setAttribute(captchaProperties.getSession().getDate(),new Date());
//        System.out.println(lineCaptcha.getCode());
//        把验证码写到浏览器之中
        lineCaptcha.write(response.getOutputStream());
        response.setContentType("image/jpeg");
        response.setCharacterEncoding("utf-8");
//        防止缓存
        response.setHeader("Pragma","No-cache");
    }

    @RequestMapping("/checkCaptcha")
    public Boolean checkCaptcha(String captcha, HttpSession session){
        System.out.println(captchaProperties);
        System.out.println(captcha);
        if(!StringUtils.hasLength(captcha)) return false;
        String code=(String)session.getAttribute(captchaProperties.getSession().getKey());
        Date date=(Date)session.getAttribute(captchaProperties.getSession().getDate());
        if(date==null||(System.currentTimeMillis()-date.getTime())>VALID_TIME_OUT) return false;
        return captcha.equalsIgnoreCase(code);
//        校验参数
//        return captcha.equals(code);
    }
}
