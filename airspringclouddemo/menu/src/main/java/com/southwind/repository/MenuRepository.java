package com.southwind.repository;

import com.southwind.entity.Menu;

import java.util.List;
//从这里映射到.xml的sql语句去管理数据库
public interface MenuRepository {
    public List<Menu> findAll(int index,int limit);
    public int count();
    public void save(Menu menu);
    public Menu findById(long id);
    public void update(Menu menu);
    public void deleteById(long id);
}
