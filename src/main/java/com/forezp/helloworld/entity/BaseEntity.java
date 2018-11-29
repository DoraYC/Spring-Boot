package com.forezp.helloworld.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Created by Carol on 2018/11/27.
 * 基于代码复用和模型分离的思想，使用MappedSuperclass注解将实体类的多个属性分别封装到不同的非实体类中
 *
 * @MappedSuperclass 注解只能在标准类上，标注了该注解的类不是一个完整的实体类，将不会映射到数据库中，
 * 但是它的属性都将映射到其子类的数据库字段中，
 * 标注了MappedSuperclass的类不能再标注@Entity或@Table注解，也无需实现序列化接口
 * 这样的类可以直接标注@EntityListeners实体监听器
 * 定义为abstract的类为父类，可被子类继承
 * implements实现接口Serializable
 */
@MappedSuperclass
@EntityListeners(value = AuditingEntityListener.class)
@Data
public abstract class BaseEntity {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    @CreatedDate
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime createdDate;

    @CreatedBy
    private String createdBy;

    @LastModifiedDate
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime lastModifiedDate;

    @LastModifiedBy
    private String lastModifiedBy;
}
