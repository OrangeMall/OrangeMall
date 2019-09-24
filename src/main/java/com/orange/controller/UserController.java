package com.orange.controller;

import com.orange.service.BrandServer;
import com.orange.service.PackingServer;
import com.orange.service.PlaceServier;
import com.orange.service.UserService;
import com.orange.vo.Brand;
import com.orange.vo.Packing;
import com.orange.vo.Place;
import com.orange.vo.User;
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
    private PackingServer pks;
    @Autowired
    private BrandServer bs;


   /* @PostMapping("/login")*/
    @RequestMapping(value="/login",method = {RequestMethod.GET,RequestMethod.POST})
    public String login(User use,String username, String password, HttpSession session, Model model)
    {
        if(us.selectuser(username,password)==null)
        {
            return "Login";
        }else
            {
                List<Place> pla=ps.selectPlace();
                for (Place pl:pla)
                {
                    System.out.println(pl.getPlid()+"******"+pl.getPlname());
                }
                List<Packing> pac=pks.selectpack();
                for (Packing pk:pac)
                {
                    System.out.println(pk.getPaid()+"*********"+pk.getPaname());
                }
                List<Brand> bra=bs.selectbrand();
                for (Brand br:bra) {
                    System.out.println(br.getBid()+"**********"+br.getBname());
                }
                System.out.println(use.getUsername()+"******"+use.getPassword());
                model.addAttribute("place",pla);
                model.addAttribute("packing",pac);
                model.addAttribute("brand",bra);
                session.setAttribute("use","use");
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
