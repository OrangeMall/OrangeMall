package com.orange.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.orange.service.OrderService;
import com.orange.vo.Address;
import com.orange.vo.Order;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class OrderController {
    @Autowired
    private OrderService os;

    /**
     * 查询所有订单\按条件查询订单
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("/order")
    public String order(Model model,HttpSession session,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum,Integer ostatus){
        PageHelper.startPage(pageNum,4);
        List<Order> order =os.selectorder();  //查询所有订单
        PageInfo<Order> pageInfo=new PageInfo<Order>(order);
        System.out.println(ostatus+"11111111111111111111111111111111111111");
        if(ostatus!=null){  //条件筛选订单   改成==5
            PageHelper.startPage(pageNum,4);
            List<Order> list =os.selectosid(ostatus); //根据订单状态查询出订单
            pageInfo=new PageInfo<Order>(list);
        }
        else{
            System.out.println("存起来pd=0"+ostatus);
            model.addAttribute("pd",0);
            model.addAttribute("order",pageInfo);
        }
        model.addAttribute("order",pageInfo);
        model.addAttribute("pd",ostatus);
            Integer wancheng = 0;//已完成订单总数
            Integer yunshu = 0;//运输中订单总数
            Integer paijian =0;//派件中订单总数
        for (Order o:pageInfo.getList()
             ) {
            if(o.getOstatus()==5){
                wancheng++;
                model.addAttribute("wc",wancheng);
               session.setAttribute("ywc",o);
            }if(o.getOstatus()==2){
                yunshu++;
                model.addAttribute("ys",yunshu);
                session.setAttribute("ysz",o);
            }
            if(o.getOstatus()==3){
                paijian++;
                model.addAttribute("pj",paijian);
                session.setAttribute("pjz",o);
            }
        }

        return "User_Orderform";
    }
}
