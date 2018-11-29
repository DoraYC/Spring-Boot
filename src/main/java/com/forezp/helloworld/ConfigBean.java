package com.forezp.helloworld;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * Created by Carol on 2018/11/27.
 * ConfigurationProperties 该属性表明该类是配置属性类，并加上配置的prefix
 * 添加Component注解，Spring Boot在启动时通过包扫描将该类作为一个Bean注入IoC容器
 */
@ConfigurationProperties(prefix = "my")
@Component
@Data
public class ConfigBean {
    private String name;
    private int age;
    private int number;
    private String uuid;
    private int max;
    private String value;
    private String greeting;

}
