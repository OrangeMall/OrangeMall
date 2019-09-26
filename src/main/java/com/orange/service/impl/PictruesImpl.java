package com.orange.service.impl;

import com.orange.dao.PictruesDao;
import com.orange.service.PictruesService;
import com.orange.vo.Pictrues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PictruesImpl implements PictruesService {
    @Autowired
    private PictruesDao pd;
    @Override
    public List<Pictrues> selectpictrues(int pid) {
        return pd.selectpictrues(pid);
    }
}
