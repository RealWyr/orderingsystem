package com.southwind.controller;


import com.southwind.entity.Menu;
import com.southwind.entity.MenuVO;
import com.southwind.entity.Type;
import com.southwind.repository.MenuRepository;
import com.southwind.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/menu")
public class MenuHandler {
//    从配置文件中读端口号值
    @Value("${server.port}")
    private String port;
    @Autowired
    private MenuRepository menuRepository;
    @Autowired
    private TypeRepository typeRepository;
    @GetMapping("/index")
    public String index(){
        return this.port;
    }

    @GetMapping("/findAll/{index}/{limit}")
    public MenuVO findAll(@PathVariable("index") int index, @PathVariable("limit") int limit){

        return new MenuVO(0,"",menuRepository.count(),menuRepository.findAll(index, limit));
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") long id){
        menuRepository.deleteById(id);
    }
    @GetMapping("/findTypes")
    public List<Type> findTypes(){
        return typeRepository.findAll();

    }
    @PostMapping("/save")
    public  void save(@RequestBody Menu menu){
//        json格式传出去所以要加@RequestBody转换成menu对象
        menuRepository.save(menu);
    }
    @GetMapping("/findById/{id}")
    public Menu findById(@PathVariable("id") long id){
        return menuRepository.findById(id);

    }

    @PutMapping("/update")
    public void update(@RequestBody Menu menu){
        menuRepository.update(menu);
    }
}
