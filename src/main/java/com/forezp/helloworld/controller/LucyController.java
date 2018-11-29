package com.forezp.helloworld.controller;

import com.forezp.helloworld.ConfigBean;
import com.forezp.helloworld.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Carol on 2018/11/27.
 * RestController 开启RestController功能
 * EnableConfigurationProperties 指明需要引用的JavaBean类，开启引用配置属性的功能
 */
@RestController
@EnableConfigurationProperties({ConfigBean.class, Person.class})
public class LucyController {

    @Autowired
    ConfigBean configBean;

    @RequestMapping(value = "/lucy")
    public String miya() {
        return configBean.getGreeting() + "-" + configBean.getName() + "-" + configBean.getUuid() + "-" + configBean.getMax();
    }

    @Autowired
    Person person;

    @RequestMapping(value = "/person")
    public String person() {
        return person.getName() + ":" + person.getAge();
    }
}
