package com.dujiangyan.tour_server.domain;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;

@Data
public class LoginInfo {

    private long id;
    private String name;
}
