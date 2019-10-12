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

    @Override
    public List<Product> move(Integer bid, Integer plid, Integer paid, String price) {
        Product pro=new Product();
        if(bid!=null)
        {
            pro.setBid(bid);
        }else
            {
                pro.setBid(null);
            }
        if(plid!=null)
        {
            pro.setPlid(plid);
        }else
            {
                pro.setPlid(null);
            }
        if(paid!=null)
        {
            pro.setPaid(paid);
        }else
            {
                pro.setPaid(null);
            }
        if(price!=null)
        {
            pro.setPrice(Double.parseDouble(price));
        }else
            {
                pro.setPrice(Double.parseDouble(price));
            }
        List<Product> list=pd.move(pro);
        if(list!=null)
        {
            return list;
        }else
            {
                return null;
            }
    }

    @Override
    public List<Product> moving(Product product) {
        return pd.move(product);
    }
}
