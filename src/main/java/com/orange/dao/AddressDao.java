package com.orange.dao;

import com.orange.vo.Address;

import java.util.List;

public interface AddressDao {
    public List<Address> selectaddress(Integer uid); //查询用户地址
}
