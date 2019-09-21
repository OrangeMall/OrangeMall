package com.orange.controller;

import com.orange.service.PlaceServier;
import com.orange.vo.Place;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

public class PlaceController {
    @Autowired
    private PlaceServier ps;
    @RequestMapping(value="/login",method = {RequestMethod.GET,RequestMethod.POST})
    public String products(Model model)
    {
       List<Place> pla=ps.selectPlace();
       if(pla!=null)
       {
           for (Place pl:pla)
           {
               System.out.println(pla);
           }
            model.addAttribute("place",pla);
           return "product_list";
       }else
           {
              return "product_list";
           }
    }
}
