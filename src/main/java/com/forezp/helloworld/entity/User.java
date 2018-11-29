package com.forezp.helloworld.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by Carol on 2018/11/27.
 * extends 继承自父类 BaseEntity
 */
@Entity
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class User extends BaseEntity{

    @Column(nullable = false,unique = true)
    private String userName;

    @Column
    private String password;
}
