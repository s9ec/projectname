package com.dao.impl;
import com.dao.ResiDao2;
import com.entity.facility;
import com.entity.record_info;
import com.util.DBconn;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ResiDaoImpl2 implements ResiDao2 {
    public List<facility> getfacilityAll() {
        List<facility> list = new ArrayList<>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from facility");
            while(rs.next()){
//                int facility_id = 0;
                facility facility1 = new facility();
                facility1.setFacility_id(rs.getInt("facility_id"));
                facility1.setFacility_name(rs.getString("facility_name"));
                facility1.setFacility_business(rs.getString("facility_business"));
                facility1.setPhone(rs.getString("phone"));;
                facility1.setDuty_people(rs.getString("duty_people"));
                facility1.setControl_people(rs.getString("control_people"));
                facility1.setMoney(rs.getInt("money"));
                list.add(facility1);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public String toString() {
        return "ResiDaoImpl2{}";
    }

//    @Override
//    public String toString() {
//        return "ResiDaoImpl{}";
//    }
    public List<record_info> getrecord(int facility_id) throws SQLException {
        List<record_info> list = new ArrayList<>();
        DBconn.init();
        String sql = "SELECT * from facility_use where facility_id = " + facility_id;//找到它的家庭成员
        ResultSet rs = DBconn.selectSql(sql);
        while(rs.next()){
            record_info m = new record_info();
            m.setRecord_id(rs.getInt("record_id"));
            m.setUse_name(rs.getString("use_name"));
            m.setUse_number(rs.getInt("use_number"));
            m.setUse_state(rs.getString("use_state"));
            m.setUse_money(rs.getInt("use_money"));
            m.setMonth(rs.getInt("month"));
            m.setDay(rs.getInt("day"));
            list.add(m);
        }
        DBconn.closeConn();
        return list;
    }
//
    public boolean exist(int facility_id) throws SQLException {
        boolean flag = false;//本不存在
        String sql =  "select count(*) from facility where facility_id = " + facility_id;
        DBconn.init();
        ResultSet rs = DBconn.selectSql(sql);
        int count = 0;
        if(rs.next()){
             count = rs.getInt("count(*)");
             if(count != 0){
                 flag = true;//有重复的啦
             }
        }
        return flag;
    }

   public boolean insert(int facility_id,String facility_name, String facility_business,String phone,String duty_people,String control_people,int money){
       boolean flag = false;
       DBconn.init();
       String sql = "insert into facility(facility_id,facility_name,facility_business,phone,duty_people,control_people,money) VALUE('"+facility_id+"','"+
               facility_name+"','"+facility_business+"','"+phone+"','" +duty_people+"','"+control_people+"','"+money+"')";
       int i =DBconn.addUpdDel(sql);
       if(i>0){
           flag = true;
       }
       DBconn.closeConn();
       return flag;
   }







    }


