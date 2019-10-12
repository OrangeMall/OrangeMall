package com.orange.service;

import com.orange.vo.Order;

import java.util.List;

public interface OrderService {
    public List<Order> selectorder();

    public List<Order> selectosid(Integer osid);//按订单状态查询订单

    public boolean saveOrder(Order order);//添加订单

}
