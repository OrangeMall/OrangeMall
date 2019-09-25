package com.orange.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 订单详情表
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Order_detail {
    private Integer did;//订单详情ID
    private Product product; //商品
    private User user;  //用户
    private Integer oid;//订单ID
    private Address addrsss; //地址

}
