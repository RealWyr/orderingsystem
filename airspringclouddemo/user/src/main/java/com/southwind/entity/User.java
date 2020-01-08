package com.southwind.entity;

import lombok.Data;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.Date;

@Data
public class User {
    private long id;
    private String username;
    private String password;
    private String nickname;
    private String gender;
    private String telephone;
    private Date registerdate;
    private String address;
}
