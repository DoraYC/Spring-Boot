package com.forezp.helloworld;

import com.forezp.helloworld.dao.RedisDao;
import lombok.extern.java.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Carol on 2018/11/28.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Log
public class SpringbootRedisApplicationTests {

    @Test
    public void contextLoads(){

    }
    @Autowired
    RedisDao redisDao;
    @Test
    public void testRedis(){
        redisDao.setKey("name","carol");
        redisDao.setKey("age","18");
        log.info(redisDao.getValue("name"));
        log.info(redisDao.getValue("age"));
    }
}
