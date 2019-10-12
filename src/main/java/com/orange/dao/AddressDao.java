package com.orange.dao;

import com.orange.vo.Address;

import java.util.List;

public interface AddressDao {
    public List<Address> selectAdd(int uid);
}
