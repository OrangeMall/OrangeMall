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
                session.setAttribute("num",1);
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
    public String login(User use, String username, String password,Model model,HttpSession session)
    {
        use=us.selectuser(username,password);
        if(use==null)
        {
            return "Login";
        }else
            {
                System.out.println(use.getUsername()+"******"+use.getPassword());
                session.setAttribute("use",use);
               /* model.addAttribute("use",use);*/
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
    public String xiaoliang(Model model,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum,HttpSession session)
    {
        PageHelper.startPage(pageNum,16);
        List<Product> list=prs.xiaoliang();
        PageInfo<Product> pageInfo=new PageInfo<Product>(list);
        System.out.println("综合条件分页id"+session.getAttribute("num"));
        int nu=(int)session.getAttribute("num");
        if(nu==2)
        {
            session.removeAttribute("num");
        }
        session.setAttribute("num",2);
        System.out.println("销量条件分页id"+session.getAttribute("num"));
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
    public String price(Model model,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum,HttpSession session)
    {
        PageHelper.startPage(pageNum,16);
        System.out.println("价格分页前的id"+session.getAttribute("num"));
        int nu=(int)session.getAttribute("num");
        if(nu==1 || nu==2)
        {
            session.removeAttribute("num");
        }
        session.setAttribute("num",3);
        System.out.println("价格分页后的id"+session.getAttribute("num"));
        List<Product> list=prs.price();
        PageInfo<Product> pageInfo=new PageInfo<Product>(list);
        model.addAttribute("pageInfo",pageInfo);
        return "product_list";
    }

    /**
     * 动态sql
     * @return
     */
    @RequestMapping(value = "move",method = {RequestMethod.GET,RequestMethod.POST})
    public String moveing(Product product,HttpSession session,
                          @RequestParam(value = "list",required = false) List<Product> list, Integer bid, Integer plid, Integer paid, String price,
                          @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum,Model model)
    {
        PageHelper.startPage(pageNum,16);
        if(product.getBid()==null)
        {
           product.setBid(null);
        }else
            {
                product.setBid(bid);
                session.setAttribute("bid",bid);
            }
        if(product.getPlid()==null)
        {
            product.setPlid(null);
        }else
            {
                Object brid=(session.getAttribute("bid"));
                if(brid!=null)
                {
                    product.setBid((int)brid);
                }
                product.setPlid(plid);
                session.setAttribute("plid",plid);
                System.out.println("品牌id**"+product.getBid());
                System.out.println("产地id+++"+plid);
            }
        if(product.getPaid()==null)
        {
            product.setPaid(null);
        }else
        {
            Object brid=(session.getAttribute("bid"));
            Object plaid=(session.getAttribute("plid"));
            if(brid!=null && plaid==null)
            {
                product.setBid((int)brid);
            }
            else if(plaid!=null && plaid ==null)
            {
                product.setPlid((int)plaid);
            }
            else if(brid!=null && plaid!=null)
            {
                product.setBid((int)brid);
                product.setBid((int)plaid);

            }
            product.setPaid(paid);
            session.setAttribute("paid",paid);
        }
        if(product.getPrice()==null)
        {
            product.setPrice(null);
        }else
        {
            Object brid=(session.getAttribute("bid"));
            Object plaid=(session.getAttribute("plid"));
            Object pacid=(session.getAttribute("paid"));
            if(brid!=null && plaid==null && pacid==null)
            {
                product.setBid((int)brid);
            }else if(plaid!=null && brid==null && pacid==null)
            {
                product.setPlid((int)plaid);
            }else if(pacid!=null && bid==null && plaid==null)
            {
                product.setPaid((int)pacid);
            }else if(brid!=null && plaid!=null && pacid!=null)
            {
                product.setBid((int)brid);
                product.setPlid((int)plaid);
                product.setPaid((int)pacid);
            }
            product.setPrice(Double.parseDouble(price));
            session.setAttribute("price",price);
        }
        list=prs.moving(product);
        System.out.println(list==null);
        PageInfo<Product> pageInfo=new PageInfo<Product>(list);
        for (Product pt:list) {
            System.out.println(pt.getPid()+"**********"+pt.getPname());
        }
        model.addAttribute("pageInfo",pageInfo);
        return"product_list";
    }
}
