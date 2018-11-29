package com.forezp.helloworld.controller.api;

import com.forezp.helloworld.entity.User;
import com.forezp.helloworld.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

/**
 * Created by Carol on 2018/11/28.
 * PathVariable :可以获取RESTful风格的Url路径上的参数
 * ApiParam：name 参数名称，参数名称会覆盖方法名称，路径参数必须和方法参数一致
 * value 参数简要说明
 * required 属性是否必填，默认为false
 */
@Api(tags = {"web user接口"})
@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    UserService userService;


    @ApiOperation(value = "获取用户", notes = "获取用户")
    @GetMapping("/name/{username}")
    public User getUser(@ApiParam(value = "用户名") @PathVariable String username) {
        return userService.findUserByName(username);
    }

    @ApiOperation(value = "获取用户列表", notes = "获取用户列表")
    @GetMapping(value = {""})
    public List<User> getUsers() {
        List<User> users = userService.findAll();
        return users;
    }

    @ApiOperation(value = "创建用户", notes = "创建用户")
    @PostMapping(value = "")
    public User postUser(@ApiParam(value = "User对象") @RequestBody User user) {
        return userService.saveUser(user);
    }

    @ApiOperation(value = "获取用户详细信息", notes = "根据url的id来获取详细信息")
    @GetMapping(value = "/{id}")
    public User getUserById(@ApiParam(value = "user id")
                            @PathVariable String id) {
        return userService.findUserById(id);
    }

    @ApiOperation(value = "更新信息", notes = "根据url的id来指定更新用户信息")
    @PutMapping(value = "/{id}")
    public User putUser(@ApiParam(value = "user id")
                        @PathVariable String id,
                        @ApiParam(value = "user 对象")
                        @RequestBody User user) {
        User user1 = new User();
        user1.setUserName(user.getUserName());
        user1.setPassword(user.getPassword());
        user1.setId(id);
        return userService.updateUser(user1);
    }

    @ApiOperation(value ="删除用户",notes="根据url的id来指定删除用户")
    @DeleteMapping(value="/{id}")
    public String deleteUser(@ApiParam(value = "user id")
                             @PathVariable String id){
        userService.deleteUser(id);
        return "success";
    }

    @ApiIgnore //使用该注解忽略这个API
    @GetMapping(value = "/hi")
    public String jsonTest(){
        return "hi, Carol!";
    }
}
