package com.orange.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Packing implements Serializable {
    private Integer paid;   //包装id
    private String paname;  //包装名称
}
