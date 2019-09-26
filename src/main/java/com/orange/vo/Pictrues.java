package com.orange.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pictrues implements Serializable {
    private Integer ptid;
    private String ptpath;
    private Integer pid;
    private Product pro;
}
