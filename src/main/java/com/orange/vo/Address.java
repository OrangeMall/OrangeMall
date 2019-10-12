package com.orange.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private Integer aid; //地址ID
    private User user ;//用户
    private String aname; //地址名字；
    private Integer phone;//电话;
    private String uname;//收货人名字；
}
