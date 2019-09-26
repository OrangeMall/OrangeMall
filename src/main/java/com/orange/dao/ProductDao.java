package com.orange.dao;

import com.orange.vo.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductDao {
    public List<Product> selectproduct();
    public List<Product> selecttoday();
    public List<Product> selectno();
    public Product selectone(@Param(value = "pid") int pid);
}
