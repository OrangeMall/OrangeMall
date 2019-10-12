package com.orange.service;

import com.orange.vo.Address;

import java.util.List;

public interface AddressService {
    public List<Address> selectaddrss(Integer uid); //查询用户地址
}
