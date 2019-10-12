package com.orange.service;

import com.orange.vo.Address;

import java.util.List;

public interface AddressService {
    public List<Address> selectAdd(int uid);
}
