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

public class Product implements Serializable {
    private Integer pid;  //商品id
    private String pname; //商品名
    private int plid;  //产地
    private int paid;  //包装id
    private double price;  //价格
    private int bid;  //品牌id
    private int nums;   //商品数量
    private String filename;    //文件名
    private String miaoshu;     //描述
}
