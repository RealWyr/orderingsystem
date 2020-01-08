package com.southwind.controller;

import com.southwind.entity.Menu;
import com.southwind.entity.MenuVO;
import com.southwind.feign.MenuFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
//返回视图
@Controller
@RequestMapping("/menu")
public class MenuHandler {

    @Autowired
    private MenuFeign menuFeign;
//    前端是问号传参，所以Getmapping里不用写参数
    @GetMapping("/findAll")
//    告诉return返回数据而不是视图
    @ResponseBody
    public MenuVO findAll(@RequestParam("page") int page, @RequestParam("limit") int limit){
        int index=(page-1)*limit;
        return menuFeign.findAll(index, limit);
    }

//    用于与前端转换
    @GetMapping("/redirect/{location}")
    public  String redirect(@PathVariable("location") String location){
        return location;
    }

    @GetMapping("/deleteById/{id}")
    public  String deleteById(@PathVariable("id") long id){
        menuFeign.deleteById(id);
//        删除后回到数据页面再发送异步到int index=....再返回数据

        return "redirect:/menu/redirect/index";
    }
//    在后台获取所有菜品类型，方便去前台添加菜品
    @GetMapping("/findTypes")
    public ModelAndView findTypes(){
        ModelAndView modelAndView =new ModelAndView();
        modelAndView.setViewName("menu_add");
        modelAndView.addObject("list",menuFeign.findTypes());
        return modelAndView;

    }
    @PostMapping("/save")
//    通过feign去调menu微服务
    public  String save(Menu menu){

        menuFeign.save(menu);
        return "redirect:/menu/redirect/index";
    }
    @GetMapping("/findById/{id}")
    public ModelAndView findById(@PathVariable("id") long id){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("menu_update");
        modelAndView.addObject("menu",menuFeign.findById(id));
        modelAndView.addObject("list",menuFeign.findTypes());
        return modelAndView;
    }

    @PostMapping("/update")
    public String update(Menu menu){
        menuFeign.update(menu);
        return "redirect:/menu/redirect/index";
    }
}
