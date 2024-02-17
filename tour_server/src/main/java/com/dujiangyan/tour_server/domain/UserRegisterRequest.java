package com.dujiangyan.tour_server.domain;

import com.dujiangyan.tour_server.entity.User;
import lombok.Data;

@Data
public class UserRegisterRequest extends User {
    private String password2;


}
