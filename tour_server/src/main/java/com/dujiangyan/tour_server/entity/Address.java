package com.dujiangyan.tour_server.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity   //表示这个类是一个实体类
@Table(name = "address")    //对应的数据库中表名称
public class Address {

    @GeneratedValue(strategy = GenerationType.IDENTITY)   //生成策略，这里配置为自增
    @Column(name = "id")    //对应表中id这一列
    @Id     //此属性为主键
    private int id;

    @Column(name = "name")   //对应表中name这一列
    private String name;

    @Column(name = "tel")
    private String tel;

    @Column(name = "place")
    private String place;

    @Column(name = "userId")
    private int userId;


}

