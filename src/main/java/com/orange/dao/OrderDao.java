package com.orange.dao;

import com.orange.vo.Order;

import java.util.List;

public interface OrderDao {
    public List<Order> selectorder();//查询订单

    public List<Order> selectosid(Integer osid);//按订单状态查询订单

    public boolean saveOrder(Order order); //生成订单

}
