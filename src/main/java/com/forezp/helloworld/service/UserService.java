package com.forezp.helloworld.service;

import com.forezp.helloworld.dao.UserDao;
import com.forezp.helloworld.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Carol on 2018/11/28.
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public User findUserByName(String userName){
        return userDao.findByUserName(userName);
    }

    public List<User> findAll(){
        return userDao.findAll();
    }

    public User findUserById(String id){
        return userDao.getOne(id);
    }

    public User saveUser(User user){
        return userDao.save(user);
    }

    public User updateUser(User user){
        return userDao.saveAndFlush(user);
    }

    public void deleteUser(String id){
        userDao.deleteById(id);
    }
}
