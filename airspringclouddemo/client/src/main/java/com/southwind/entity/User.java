package com.southwind.entity;
//client中实体类作用：别的地方传过来的是json数据，需要用实体类解析
import lombok.Data;

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
