package com.orange.service.impl;

import com.orange.dao.OrderDao;
import com.orange.service.OrderService;
import com.orange.vo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Orderimpl implements OrderService {
    @Autowired
    private OrderDao od;
    @Override
    public List<Order> selectorder() {
        return od.selectorder();
    }

    @Override
    public List<Order> selectosid(Integer osid) {
        return od.selectosid(osid);
    }

    @Override
    public boolean saveOrder(Order order) {
        return od.saveOrder(order);
    }

}
