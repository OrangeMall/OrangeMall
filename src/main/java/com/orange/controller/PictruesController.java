package com.orange.controller;

import com.orange.service.PictruesService;
import com.orange.service.ProductServer;
import com.orange.vo.Pictrues;
import com.orange.vo.Product;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PictruesController {
    @Autowired
    private PictruesService ps;
    @Autowired
    private ProductServer pds;

    @GetMapping(value = "pictrues")
    public String pictr(@Param(value = "pid") int pid, Model model)
    {
        System.out.println(pid);
        List<Pictrues> pic=ps.selectpictrues(pid);
        for (Pictrues pi:pic) {
            System.out.println(pi.getPro().getPid()+"**********"+pi.getPtpath());
        }
        Product pr=pds.selectone(pid);
        System.out.println("详情图片路劲"+pr.getFilename());
        model.addAttribute("pictrues",pic);
        model.addAttribute("product",pr);
        return "Product_Detailed";
    }
}
