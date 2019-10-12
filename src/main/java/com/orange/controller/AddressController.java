package com.orange.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.orange.service.AddressService;
import com.orange.vo.Address;
import com.orange.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class AddressController {
    @Autowired
    private AddressService as;

    @RequestMapping("/address")
    public String address(Model model, Integer uid, @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum, HttpSession session){
        PageHelper.startPage(pageNum,4);
        List<Address> address = as.selectaddrss(uid);
        PageInfo<Address> pageInfo=new PageInfo<Address>(address);
        for (Address a:address
             ) {
            System.out.println("收货地址：  "+a.getAname());
            System.out.println("收货人姓名：  "+a.getUname());
            System.out.println("收货人手机号码：  "+a.getPhone());
        }
        model.addAttribute("address",pageInfo);
        return "User_address";
    }
}
