package com.orange.vo;

import lombok.*;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private Integer pid;
    private String pname;  //商品名字
    private Integer plid;   //产品id
    private Place  place; //产地类
    private Integer paid; //包装种类ID
    private Double price; //价格
    private Brand brand;//商品品牌
    private Integer bid;  //商品id
    private Integer nums;//库存
    private String filename;//图片路劲
    private String miaoshu;//描述
    private Date time;  //上架时间
}
