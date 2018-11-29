package com.forezp.helloworld;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created by Carol on 2018/11/27.
 * PropertySource 注解只可以加载properties文件，无法加载yml文件,
 * 若要加载yml自定义配置文件，需要先添加YmlConfig配置类，再引用
 */
//@Configuration
//@PropertySource(value = "classpath:test.properties") // 自定义配置文件使用
@Component
@ConfigurationProperties(prefix = "com.forezp")
@Data
public class Person {
    private String name;
    private int age;
}
