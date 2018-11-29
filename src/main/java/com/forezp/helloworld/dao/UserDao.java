package com.forezp.helloworld.dao;

import com.forezp.helloworld.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * Created by Carol on 2018/11/28.
 * 数据访问层 DAO,该类继承JpaRepository 的接口，继承之后就可以对数据库进行读写操作
 * JpaSpecificationExecutor 动态构建查询条件，实现复杂查询
 */
@Repository
public interface UserDao extends JpaRepository<User,String>, JpaSpecificationExecutor {

    User findByUserName(String userName);

}
