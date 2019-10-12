package com.orange.service.impl;

import com.orange.dao.ShopCarDao;
import com.orange.service.ShopCarService;
import com.orange.vo.ShopCar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopCarImpl implements ShopCarService {
    @Autowired
    private ShopCarDao sc;

    @Override
    public List<ShopCar> car(int uid) {
        return sc.car(uid) ;
    }
}
