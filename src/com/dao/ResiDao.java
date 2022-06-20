package com.dao;

import com.entity.resident.Address;
import com.entity.resident.Member_info;
import com.entity.resident.Resident;

import java.sql.SQLException;
import java.util.List;

public interface ResiDao {//接口

    List<Resident> getResiAll();//返回用户信息集合
    boolean delete(int hid) ;//根据id删除用户
    //public boolean update(int id,String name, String pwd) ;//更新用户信息
    //public int count() throws SQLException;
    List<Member_info> getFamily(int hid) throws SQLException;
    boolean exist(Address address) throws SQLException;
    boolean update(String sql);
    List<Resident> queryInfo(String info, String method) throws SQLException;
    Member_info FamilyMember(int id) throws SQLException;
    boolean deleteMember(int id);
}
