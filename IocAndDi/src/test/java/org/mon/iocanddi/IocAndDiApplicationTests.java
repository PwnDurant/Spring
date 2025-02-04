package org.mon.iocanddi;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import cn.hutool.core.lang.Console;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class IocAndDiApplicationTests {

    @Test
    void contextLoads() {
        //定义图形验证码的长和宽
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(200, 100);

        //图形验证码写出，可以写出到文件，也可以写出到流
        lineCaptcha.write("/Users/zhaoqianqian/Downloads/captcha/line.png");
        //输出code
        System.out.println(lineCaptcha.getCode());
        //        Console.log(lineCaptcha.getCode());
        //验证图形验证码的有效性，返回boolean值
        boolean verify=lineCaptcha.verify("1234");
        System.out.println(verify);
//        //重新生成验证码
//        lineCaptcha.createCode();
//        lineCaptcha.write("/Users/zhaoqianqian/Downloads");
//        //新的验证码
//        System.out.println(lineCaptcha.getCode());
//        //        Console.log(lineCaptcha.getCode());
//        //验证图形验证码的有效性，返回boolean值
//        lineCaptcha.verify("1234");
    }

}
