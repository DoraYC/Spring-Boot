package com.forezp.helloworld.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

/**
 * Created by Carol on 2018/11/28.
 * 该类通过StringRedisTemplate来访问Redis。通过注入StringRedisTemplate 的Bean 来对Redis数据库中的字符串类型的数据进行操作，
 * 写了两个方法，包括向Redis中设置String类型的数据和从Redis中读取String类型的数据
 */
@Repository
public class RedisDao {
    @Autowired
    private StringRedisTemplate template;

    public void setKey(String key, String value) {
        ValueOperations<String, String> ops = template.opsForValue();
        ops.set(key, value, 1, TimeUnit.MINUTES);//1分钟过期
    }

    public String getValue(String key) {
        ValueOperations<String, String> ops = this.template.opsForValue();
        return ops.get(key);
    }

}
