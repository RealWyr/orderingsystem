package com.southwind.controller;

import com.southwind.entity.User;
import com.southwind.entity.UserVO;
import com.southwind.feign.UserFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
//需要用到前端视图所以不能用RestController
@Controller
@RequestMapping("/user")
public class UserHandler {
    @Autowired
    private UserFeign userFeign;

    @GetMapping("/findAll")
    @ResponseBody
//    把数据返回，微服务之间需要通过rest沟通，rest会封装数据成json数据，所以需要@Requsetbody将json转换成user对象，若不加传入为空数据

    public UserVO findAll(@RequestParam("page") int page, @RequestParam("limit") int limit){
        int index=(page-1)*limit;
        UserVO userVO=new UserVO();
        userVO.setCode(0);
        userVO.setMsg("");
        userVO.setCount(userFeign.count());
        userVO.setData(userFeign.findAll(index,limit));
        return userVO;
    }

    @GetMapping("/redirect/{location}")
//    用于与前端转换，location是页面，通过后端return映射到页面代码，发一个异步请求回到findAll加载数据
    public  String redirect(@PathVariable("location") String location){
        return location;
    }


    @GetMapping("/count")
    public int count(){
        return userFeign.count();
    }

    //    微服务之间需要通过rest沟通，rest会封装数据成json数据，所以需要@Requsetbody将json转换成user对象，若不加传入为空数据
    @PostMapping("/save")
    public String save(User user){
        user.setRegisterdate(new Date());
        userFeign.save(user);
        return "redirect:/user/redirect/user_manage";
    }


    @GetMapping("deleteById/{id}")
//    删除后重新加载数据返回到location
    public String deleteById(@PathVariable("id") long id){
        userFeign.deleteById(id);
        return "redirect:/user/redirect/user_manage";
    }
}


