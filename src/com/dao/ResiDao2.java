package com.dao;
import com.entity.facility;
import com.entity.record_info;

import java.sql.SQLException;
import java.util.List;

public interface ResiDao2 {//接口
    public List<facility> getfacilityAll();//返回用户信息集合
    public List<record_info> getrecord(int facility_id) throws SQLException;
    public boolean insert(int facility_id,String facility_name, String facility_business,String phone,String duty_people,String control_people,int money);
    public boolean exist(int facility_id) throws SQLException;
    // public boolean delete(int id) ;//根据id删除用户
    //public boolean update(int id,String name, String pwd) ;//更新用户信息
    //public int count() throws SQLException;
//    public List<Member_info> getFamily(int hid) throws SQLException;
//    public boolean exist(Address address) throws SQLException;
//    public boolean update(String sql);
}
