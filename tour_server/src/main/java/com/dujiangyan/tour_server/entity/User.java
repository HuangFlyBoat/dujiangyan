package com.dujiangyan.tour_server.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private long userId;

    @Column(name = "password")
    private String password;

    @Column(name = "userName")
    private String userName;
}
