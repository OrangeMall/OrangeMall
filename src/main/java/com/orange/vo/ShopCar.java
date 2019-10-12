package com.orange.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShopCar implements Serializable {
    private Integer sid;
    private Integer uid;
    private Integer pid;
    private Integer snums;
    private User user;
    private Product product;
}
