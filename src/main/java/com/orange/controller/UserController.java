package com.orange.controller;

import com.orange.service.*;
import com.orange.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
public class UserController {
    @Autowired
    private UserService us;
    @Autowired
    private PlaceServier ps;
    @Autowired
    private PackingService pks;
    @Autowired
    private BrandService bs;
    @Autowired
    private ProductService prs;

   /* @PostMapping("/login")*/
    @RequestMapping(value="/login",method = {RequestMethod.GET,RequestMethod.POST})
    public String login(User use,String username, String password, HttpSession session, Model model)
    {
        if(us.selectuser(username,password)==null)
        {
            return "Login";
        }else
            {
                List<Place> pla=ps.selectPlace();//查询产地
                for (Place pl:pla)
                {
                    System.out.println(pl.getPlid()+"******"+pl.getPlname());
                }
                List<Packing> pac=pks.selectpack();//包装方式
                for (Packing pk:pac)
                {
                    System.out.println(pk.getPaid()+"*********"+pk.getPaname());
                }
                List<Brand> bra=bs.selectbrand();//品牌
                for (Brand br:bra) {
                    System.out.println(br.getBid()+"**********"+br.getBname());
                }
                List<Product> pro=prs.selectproduct();//商品详细
                for (Product pt:pro) {
                    System.out.println(pt.getPrice()+"-----"+pt.getMiaoshu()+"-----"+pt.getFilename());
                }
                List<Product> pd=prs.selecttoday();//今日推荐
                for (Product pc:pd) {
                    System.out.println(pc.getPrice()+"******"+pc.getFilename()+"******"+pc.getNums()+"******"+pc.getMiaoshu());
                }
                List<Product> po=prs.selectno();//商品销量
                for (Product pu:po) {
                    System.out.println(pu.getPrice()+"******"+pu.getMiaoshu());
                }
                System.out.println(use.getUsername()+"******"+use.getPassword());
                model.addAttribute("place",pla);
                model.addAttribute("packing",pac);
                model.addAttribute("brand",bra);
                model.addAttribute("product",pro);
                model.addAttribute("today",pd);
                model.addAttribute("no",po);
                /*session.setAttribute("use","use");*/
                model.addAttribute("use",use);
                return "product_list";
            }
    }

    /**
     * 注册
     * @param user
     * @return
     */
    @PostMapping("/regist")
    public String regist(User user)
    {
        if(us.insertuser(user)>0)
        {
            System.out.println(user.getUsername()+user.getPassword());
            return "Login";
        }else
            {
                return "Registered.html";
            }
    }
}
