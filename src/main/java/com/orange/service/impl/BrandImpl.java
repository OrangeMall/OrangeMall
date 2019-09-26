package com.orange.service.impl;

import com.orange.dao.BrandDao;
import com.orange.service.BrandService;
import com.orange.vo.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandImpl implements BrandService {
    @Autowired
    private BrandDao bd;

    @Override
    public List<Brand> selectbrand() {
        return bd.selectbrand();
    }
}
