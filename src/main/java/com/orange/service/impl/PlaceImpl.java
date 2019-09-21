package com.orange.service.impl;

import com.orange.dao.PlaceDao;
import com.orange.service.PlaceServier;
import com.orange.vo.Place;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaceImpl implements PlaceServier {
    @Autowired
    private PlaceDao pd;
    @Override
    public List<Place> selectPlace() {
        return pd.selectplace();
    }
}
