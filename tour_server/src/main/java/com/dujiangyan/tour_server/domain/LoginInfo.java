package com.dujiangyan.tour_server.domain;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;

import java.io.Serializable;

@Data
public class LoginInfo  implements Serializable {

    private int id;
    private String name;
}
