package com.orange.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 订单实体类
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private Integer oid;
    private String otime;  //下单时间
    private Integer ostatus;//订单状态
    private Order_detail order_detail ;//  订单详情编号；
}
