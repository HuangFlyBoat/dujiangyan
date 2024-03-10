package com.dujiangyan.tour_server.domain;

import com.dujiangyan.tour_server.entity.Address;
import com.dujiangyan.tour_server.entity.Detail;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
public class OrderDTO {


    private int id;


    private int userId;


    private String date;

    private BigDecimal total;

    private Address address;



}
