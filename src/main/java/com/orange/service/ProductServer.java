package com.orange.service;

import com.orange.vo.Product;

import java.util.List;

public interface ProductServer {
    public List<Product> selectproduct();
    public List<Product> selecttoday();
    public List<Product> selectno();
}
