package com.orange.service.impl;

import com.orange.dao.ProductDao;
import com.orange.service.ProductService;
import com.orange.vo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductImpl implements ProductService {
    @Autowired
    private ProductDao pd;
    @Override
    public List<Product> selectproduct() {
        return pd.selectproduct();
    }

    @Override
    public List<Product> selecttoday() {
        return pd.selecttoday();
    }

    @Override
    public List<Product> selectno() {
        return pd.selectno();
    }

    @Override
    public Product selectone(int pid) {
       return pd.selectone(pid);
    }

    @Override
    public List<Product> selectfive() {
        return pd.selectfive();
    }

    @Override
    public List<Product> xiaoliang() {
        return pd.xiaoliang();
    }

    @Override
    public List<Product> price() {
        return pd.price();
    }
}
