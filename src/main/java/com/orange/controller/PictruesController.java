package com.orange.controller;

import com.orange.service.PackingService;
import com.orange.service.PictruesService;
import com.orange.service.ProductService;
import com.orange.vo.Packing;
import com.orange.vo.Pictrues;
import com.orange.vo.Product;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PictruesController {
    @Autowired
    private PictruesService ps;
    @Autowired
    private ProductService pds;
    @Autowired
    private PackingService pas;

    @GetMapping(value = "pictrues")
    public String pictr(@Param(value = "pid") int pid, Model model)
    {
        System.out.println(pid);
        List<Pictrues> pic=ps.selectpictrues(pid);
        for (Pictrues pi:pic) {
            System.out.println(pi.getPro().getPid()+"**********"+pi.getPtpath());
        }
        List<Packing> pack=pas.selectpack();
        Product pr=pds.selectone(pid);
        System.out.println("上架时间："+pr.getTime());
        System.out.println("详情图片路劲"+pr.getFilename());
        model.addAttribute("pictrues",pic);
        model.addAttribute("product",pr);
        model.addAttribute("packing",pack);
        return "Product_Detailed";
    }
}
