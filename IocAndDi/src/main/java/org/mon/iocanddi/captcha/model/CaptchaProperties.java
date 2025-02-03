package org.mon.iocanddi.captcha.model;



import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


@Data
@Configuration
@ConfigurationProperties(prefix = "captcha")
public class CaptchaProperties {
    private Integer width;
    private Integer height;
    private Session session;

//    @Data
//    @Configuration
//    @ConfigurationProperties(prefix = "captcha.session")
    @Data
//    要先创建一下才可以进行使用，加入static
    public static class Session{
        private String key;
        private String date;
    }
}
