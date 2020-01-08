package com.southwind.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Setter
@Data
public class UserVO {
    private int code;
    private String msg;
    private int count;
    private List<User> data;
}
