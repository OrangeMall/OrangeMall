package com.orange.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User  implements Serializable {
    private Integer uid;
    private String username;
    private String password;
    private String sex;
    private String email;
    private String qq;
    private String iphone;
    private String heard;
    private Integer status;
    private Integer balance;
}
