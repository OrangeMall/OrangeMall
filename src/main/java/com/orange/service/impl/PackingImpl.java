package com.orange.service.impl;

import com.orange.dao.PackingDao;
import com.orange.service.PackingService;
import com.orange.vo.Packing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PackingImpl implements PackingService {
    @Autowired
    private PackingDao pd;
    @Override
    public List<Packing> selectpack() {
        return pd.selectpack();
    }
}
