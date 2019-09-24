package com.orange.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * 产地类
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Place implements Serializable {
    private Integer pid;
    private String pname;
}
