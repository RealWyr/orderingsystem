package com.southwind.feign;

import com.southwind.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value="user")
//关联到user模块
public interface UserFeign {
//        这个user关联到user模块中的handler
        @GetMapping("/user/findAll/{index}/{limit}")
        public List<User> findAll(@PathVariable("index") int index,@PathVariable("limit") int limit);

        @GetMapping("/user/findById/{id}")
        public User findById(@PathVariable("id") long id);

        @GetMapping("/user/count")
        public int count();

        @PostMapping("/user/save")
        public void save(@RequestBody User user);
        @PostMapping("/user/update")
        public void update(@RequestBody User user);

        @DeleteMapping("/user/deleteById/{id}")
        public void deleteById(@PathVariable("id") long id);
    }

