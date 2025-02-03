package org.mon.iocanddi.ioc.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;


@Data
@Configuration
@ConfigurationProperties(prefix = "student")
public class StudentConfig {

    private Integer id;
    private String name;
    private Integer age;
    private List<String> dbtype;
    private Map<String,String> map;
}
