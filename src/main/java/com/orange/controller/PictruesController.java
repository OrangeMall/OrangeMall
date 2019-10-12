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

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
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
    public String pictr(@Param(value = "pid") int pid, Model model, HttpServletResponse response, HttpServletRequest request,HttpSession session)
    {
        System.out.println(pid);
        List<Pictrues> pic=ps.selectpictrues(pid);//商品小照片
        for (Pictrues pi:pic) {
            System.out.println(pi.getPro().getPid()+"**********"+pi.getPtpath());
        }
        List<Packing> pack=pas.selectpack();//包装方式
        Product pr=pds.selectone(pid);//商品大图片

        Cookie[] cks = request.getCookies();//获取客户端所有Cookie
        Cookie ck = null;
        if (cks != null) {
            for (Cookie cookie : cks) {
                if (cookie.getName().equals("browse")) {//循环找name是browse的Cookie
                    ck = cookie;
                }
            }
        }

        if (ck == null) {
            ck = new Cookie("browse", String.valueOf(pid));//如果ck=null,新建一个cookie名为browse,将用户第一次浏览的商品ID保存进去
        } else {
            String ckk = ck.getValue();//获取ck的value值
            System.out.println("未拆分" + ckk);
            String str = "";
            int i = 0;
            String[] cksstr = ckk.split("#");//按照,拆分保存在cksstr数组里
            for (String ckss : cksstr) {
                if (Integer.parseInt(ckss)==pid) {
                    continue;
                }
                if (str == "") {
                    str += pid + "#" + ckss;
                } else {
                    str = str + "#" + ckss;
                }
                i++;
                if (i > 3)
                {
                    break;
                }
            }
            if(str==""){
                str=String.valueOf(pid);
                for(String ckss : cksstr){
                    if (Integer.parseInt(ckss)!=pid) {
                        str+="#"+ckss;
                    }
                }
            }
            ck.setValue(str);
        }
        response.addCookie(ck);
        String[] num = ck.getValue().split("#");
        List<Product> pla = new ArrayList<Product>();
        for (int i = 0; i < num.length; i++) {
            System.out.println(num[i]);
            pla.add(pds.selectone(Integer.parseInt(num[i])));
        }
        for (Product p : pla) {
            System.out.println(p.getPid() + "******" + p.getPname());
        }
        session.setAttribute("prod",pla);

        System.out.println("上架时间："+pr.getTime());
        System.out.println("详情图片路劲"+pr.getFilename());
        model.addAttribute("pictrues",pic);
        model.addAttribute("product",pr);
        model.addAttribute("packing",pack);
        return "Product_Detailed";
    }

    public String getCookie(HttpServletRequest request, HttpServletResponse response, HttpSession session,String pid)
    {
        Cookie [] cook=request.getCookies();  //创建Cookie对象
        Cookie ck=null;
        if(cook!=null)
        {
            for (Cookie ce:cook)
            {
                if(ce.getName().equals("products"))
                {
                    ck=ce;
                }
            }
            if(ck!=null)
            {
                String [] str=ck.getValue().split("#");
                List<Product> pro=new ArrayList<Product>();
                for (int i=0;i<str.length;i++)
                {
                    System.out.println(str[i]);
                    pro.add(pds.selectone(Integer.parseInt(pid)));
                }
                for (Product pt:pro)
                {
                    System.out.println(pt.getPid()+"*******"+pt.getPname());
                }
                session.setAttribute("prod",pro);
            }
        }
        return "product_list";
    }
}
