package com.dao;

import com.entity.resident.User;
import com.entity.facility;
import com.entity.news;

import java.sql.SQLException;
import java.util.List;

public interface UsersDao {//接口

    public List<facility> getfacilityAll(int facility_id);//返回用户信息集合
    public  List<User> getUserAll();
    public boolean delete(int id) ;//根据id删除用户
    public boolean delete2(int id) ;
    public boolean update(int facility_id, String facility_name,String facility_business, String phone,String duty_people, String control_people, int money ) ;//更新用户信息
    public int count() throws SQLException;
    public List<facility> search(int facility_id);
    public List<facility> search2(String facility_name);
    public List<facility> search3(int money);
    public List<news> search4(int news_id);
    public List<news> search6(String name);
    public List<news> search5(String content);
    public boolean getcontent(int news_id) throws SQLException;
    public int getnewsAll2(String news_content);
    public List<news> getnewsAll5(int news_id);
    public boolean update1(int news_id,String news_content,int month, int day);
}
