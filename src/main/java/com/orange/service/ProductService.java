package com.orange.service;

import com.orange.vo.Product;

import java.util.List;

public interface ProductService {
    public List<Product> selectproduct();
    public List<Product> selecttoday();
    public List<Product> selectno();
    public Product selectone(int pid);
    public List<Product> selectfive();
    public List<Product> xiaoliang();
    public List<Product> price();
    public List<Product> move(Integer bid,Integer plid,Integer paid,String price);
    public List<Product> moving(Product product);
}
