package com.orange.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private Integer pid;
    private String pname;  //商品名字
    private Place  place; //产地类
    private Integer paid; //包装种类ID
    private Double price; //价格
    private Brand brand;//商品品牌
    private Integer nums;//库存
    private String filename;//图片路劲
    private String miaoshu;//描述
}
