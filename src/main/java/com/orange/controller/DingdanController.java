package com.orange.controller;

import com.orange.service.AddressService;
import com.orange.vo.Address;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class DingdanController {
    @Autowired
    private AddressService as;

    @RequestMapping(value="address",method = {RequestMethod.GET,RequestMethod.POST})
    public String address(int uid, Model model)
    {
        List<Address> add=as.selectAdd(uid);
        for (Address ad:add) {
            System.out.println(ad.getUser().getUid()+"******"+ad.getAname());
        }
        model.addAttribute("address",add);
        return "Orders_confirm";
    }
}
