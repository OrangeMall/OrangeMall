package com.orange.dao;

import com.orange.vo.Product;

import java.util.List;

public interface ProductDao {
    public List<Product> selectproduct();
    public List<Product> selecttoday();
    public List<Product> selectno();
}
