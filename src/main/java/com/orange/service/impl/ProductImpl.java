package com.orange.service.impl;

import com.orange.dao.ProductDao;
import com.orange.service.ProductServer;
import com.orange.vo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductImpl implements ProductServer {
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
}
