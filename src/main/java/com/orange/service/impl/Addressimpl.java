package com.orange.service.impl;

import com.orange.dao.AddressDao;
import com.orange.service.AddressService;
import com.orange.vo.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Addressimpl implements AddressService {
    @Autowired
    private AddressDao ad;
    @Override
    public List<Address> selectaddrss(Integer uid) {
        return ad.selectaddress(uid);
    }
}
