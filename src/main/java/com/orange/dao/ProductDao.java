package com.orange.dao;

import com.orange.vo.Product;
import org.apache.ibatis.annotations.Param;

import java.io.PipedOutputStream;
import java.util.List;

public interface ProductDao {
    public List<Product> selectproduct();
    public List<Product> selecttoday();
    public List<Product> selectno();
    public Product selectone(@Param(value = "pid") int pid);
    public List<Product> selectfive();
    public List<Product> xiaoliang();
    public List<Product> price();
}
