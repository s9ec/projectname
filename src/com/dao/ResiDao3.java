package com.dao;


import com.entity.news;

import java.sql.SQLException;
import java.util.List;

public interface ResiDao3 {//接口

    public List<news> getnewsAll();//返回用户信息集合
    public List<String > checknewsAll();
    public boolean insert(String news_content,int month, int day,String name);
    public boolean exist(int news_id) throws SQLException;

}
