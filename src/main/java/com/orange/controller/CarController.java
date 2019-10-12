package com.orange.controller;

import com.orange.service.ProductService;
import com.orange.service.ShopCarService;
import com.orange.vo.Product;
import com.orange.vo.ShopCar;
import com.orange.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CarController {
    @Autowired
    private ProductService ps;
    @Autowired
    private ShopCarService ss;

  /*  @RequestMapping(value="shopcar",method = {RequestMethod.GET,RequestMethod.POST})
    public String car(HttpServletRequest request, int pid)
    {
        HttpSession session=request.getSession();
        Product pd=ps.selectone(pid);
        Map<Product,Integer> map=(Map<Product, Integer>) session.getAttribute("shopcar");
        //没有添加东西到购物车
        if(map==null)
        {
            map=new HashMap<Product,Integer>();
        }
        //判断购物车里面是否有该商品 ，如果有  数量 + 1  ，如果没有，数量-1
        if(map.containsKey(pd))
        {
            map.put(pd,map.get(pd)+1);
        }else
            {
                map.put(pd,1);
            }
        request.getSession().setAttribute("shopcar",map);
        return "Shop_cart";
        *//*return "redirect:Shop_cart.html";*//*
    }*/
    @RequestMapping(value="shopcar",method = {RequestMethod.GET,RequestMethod.POST})
    public String car(Model model, HttpSession session, User user, HttpServletResponse response) throws IOException {
        response.setContentType("text/html; charset=UTF-8"); //转码
        user=(User) session.getAttribute("use");
        PrintWriter out=response.getWriter();
        if(user==null)
        {
            out.flush();
            out.println("<script>");
            out.println("alert('请先登录！');");
            out.println("</script>");
            return"Login";
        }else
            {
                int uid=user.getUid();
                System.out.println("登录后的用户id"+uid);
                List<ShopCar> shop=ss.car(uid);
                double money=0;
                double all=0;
                for (ShopCar sc:shop) {
                    int num=sc.getSnums();
                    double cash=sc.getProduct().getPrice();
                    money=num*cash;
                    all+=money;
                    System.out.println(sc.getProduct().getPid()+"++++++++"+sc.getUser().getUid()+"*******"+sc.getSid());
                    System.out.println(money);
                }
                all=(double)Math.round(all*100)/100;
                System.out.println(all);
                session.setAttribute("qian",all);
                /*model.addAttribute("shop",shop);*/
                session.setAttribute("shop",shop);
                return "Shop_cart";
            }
    }
}
