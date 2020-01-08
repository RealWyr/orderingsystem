package com.southwind.feign;
//handler调feign,feign调服务提供者menu
import com.southwind.entity.Menu;
import com.southwind.entity.MenuVO;
import com.southwind.entity.Type;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//关联到menu，在注册中心的名字
@FeignClient(value = "menu")
public interface MenuFeign {

//    到menu的handler里获得index，limit
    @GetMapping("/menu/findAll/{index}/{limit}")
    public MenuVO findAll(@PathVariable("index") int index, @PathVariable("limit") int limit);
    @DeleteMapping("/menu/deleteById/{id}")
//    直接访问到了MenuHandler中的@DeleteMapping
    public void deleteById(@PathVariable("id") long id);

    @GetMapping("/menu/findTypes")
    public List<Type> findTypes();

    @PostMapping("/menu/save")
    public void save(Menu menu);

    @GetMapping("/menu/findById/{id}")
    public Menu findById(@PathVariable long id);

    @PutMapping("/menu/update")
    public void update(Menu menu);
}
