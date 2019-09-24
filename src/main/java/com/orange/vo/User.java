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
    private Integer uid; //用户id
    private String username;    //用户名
    private String password;    //密码
    private String sex;     //性别
    private String email;   //邮件
    private String qq;  //qq
    private String iphone;  //电话
    private String heard;   //头像
    private Integer status;     //是否为管理员
    private Integer balance;    //余额
}
