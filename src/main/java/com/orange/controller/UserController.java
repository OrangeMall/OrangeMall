package com.orange.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.orange.service.*;
import com.orange.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
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

    /**
     *首页
     * @param session
     * @param model
     * @param pageNum
     * @return
     */
    @RequestMapping(value="index",method = {RequestMethod.GET,RequestMethod.POST})
    public String login(HttpSession session, Model model,
                        @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum)
    {
                List<Place> pla=ps.selectPlace();//查询产地
                List<Packing> pac=pks.selectpack();//包装方式
                List<Brand> bra=bs.selectbrand();//品牌
                PageHelper.startPage(pageNum,16);//分页
                List<Product> list=prs.selectproduct();//商品详细
                PageInfo<Product> pageInfo=new PageInfo<Product>(list);
                List<Product> pd=prs.selecttoday();//今日推荐
                List<Product> po=prs.selectno();//商品销量
                List<Product> pt=prs.selectfive();//搜索框下面
                session.setAttribute("place",pla);
                session.setAttribute("packing",pac);
                session.setAttribute("brand",bra);
                session.setAttribute("today",pd);
                session.setAttribute("no",po);
                session.setAttribute("five",pt);
                model.addAttribute("pageInfo",pageInfo);
                return "product_list";
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

    /**
     * 登录
     * @param use
     * @param username
     * @param password
     * @param model
     * @return
     */
    @RequestMapping(value="login",method = {RequestMethod.GET,RequestMethod.POST})
    public String login(User use, String username, String password,Model model)
    {
        if(us.selectuser(username,password)==null)
        {
            return "Login";
        }else
            {
                System.out.println(use.getUsername()+"******"+use.getPassword());
                model.addAttribute("use",use);
                return "forward:/index";
            }
    }

    /**
     * 按照销量查询
     * @param model
     * @param pageNum
     * @return
     */
    @RequestMapping(value="sale",method = {RequestMethod.GET,RequestMethod.POST})
    public String xiaoliang(Model model,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum)
    {
        PageHelper.startPage(pageNum,16);
        List<Product> list=prs.xiaoliang();
        PageInfo<Product> pageInfo=new PageInfo<Product>(list);
        model.addAttribute("pageInfo",pageInfo);
        return "product_list";
    }

    /**
     * 按照价格查询
     * @param model
     * @param pageNum
     * @return
     */
    @RequestMapping(value="money",method = {RequestMethod.GET,RequestMethod.POST})
    public String price(Model model,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum)
    {
        PageHelper.startPage(pageNum,16);
        List<Product> list=prs.price();
        PageInfo<Product> pageInfo=new PageInfo<Product>(list);
        model.addAttribute("pageInfo",pageInfo);
        return "product_list";
    }
}
