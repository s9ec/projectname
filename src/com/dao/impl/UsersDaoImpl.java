package com.dao.impl;

import com.dao.UsersDao;
import com.entity.resident.User;
import com.entity.facility;
import com.entity.news;


import com.util.DBconn;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsersDaoImpl implements UsersDao{


    public List<User> getUserAll() {
        List<User> list = new ArrayList<User>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from user");
            while(rs.next()){
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setPwd(rs.getString("pwd"));
                list.add(user);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<facility> getfacilityAll(int facility_id) {
        List<facility> list = new ArrayList<facility>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from facility where facility_id= "+facility_id);
            while(rs.next()){
                facility facility = new facility();
                facility.setFacility_id(facility_id);
                facility.setFacility_name(rs.getString("facility_name"));
                facility.setFacility_business(rs.getString("facility_business"));
                facility.setPhone(rs.getString("phone"));;
                facility.setDuty_people(rs.getString("duty_people"));
                facility.setControl_people(rs.getString("control_people"));
                facility.setMoney(rs.getInt("money"));
                list.add(facility);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<news> getnewsAll5(int news_id) {
        List<news> list = new ArrayList<news>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from news where news_id= "+news_id);
            while(rs.next()){
                news news1 = new news();
                news1.setNews_id(rs.getInt("news_id"));
                news1.setNews_content(rs.getString("news_content"));
                news1.setMonth(rs.getInt("month"));
                news1.setDay(rs.getInt("day"));
                news1.setName(rs.getString("name"));
                news1.setPublished(rs.getString("published"));
                list.add(news1);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public boolean getcontent(int news_id) throws SQLException {
        boolean flag = false;
        DBconn.init();
        String s = "select published from news where news_id =" + news_id;
        ResultSet rs = DBconn.selectSql(s);
        String status = "yes";
        if(rs.next()){
            if(rs.getString("published").equals("yes")){
                status = "no";
            }
        }
        String sql = "update news set published ='"+ status +"' where news_id = " + news_id;
        int i = DBconn.addUpdDel(sql);
        if(i>0){
            flag = true;
        }
        DBconn.closeConn();
        return flag;
    }
    public int getnewsAll2(String news_content) {
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from news where news_content ='"+news_content+"'");
            if(rs.next()){
                int i;
                i= rs.getInt("news_id");
                return i;
            }
            DBconn.closeConn();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public boolean update(int facility_id, String facility_name,String facility_business, String phone,String duty_people, String control_people, int money ) {
        boolean flag = false;
        DBconn.init();
        String sql ="update facility set facility_name ='"+facility_name
                +"' , facility_business ='"+facility_business +
                "', phone='"+phone+"',duty_people='"+duty_people+"',control_people='"+control_people + "' , money="+money +
                " where facility_id = "+facility_id;
        int i =DBconn.addUpdDel(sql);
        if(i>0){
            flag = true;
        }
        DBconn.closeConn();
        return flag;
    }
    public boolean update1(int news_id,String news_content,int month, int day) {
        boolean flag = false;
        DBconn.init();
        String sql ="update news set news_content ='"+news_content
                +"' , month ="+month +
                ", day="+day +
                " where news_id = "+news_id;
        int i =DBconn.addUpdDel(sql);
        if(i>0){
            flag = true;
        }
        DBconn.closeConn();
        return flag;
    }

    @Override
    public int count() throws SQLException {
        int ans = -1;
        DBconn.init();
        String sql = "select count(*) from user";
        ResultSet rs = DBconn.selectSql(sql);
        if(rs.next()){
            ans = rs.getInt("count(*)");
        }
        DBconn.closeConn();
        return ans;
    }

    public boolean delete(int id) {
        boolean flag = false;
        DBconn.init();
        String sql = "delete  from facility where facility_id="+id;
        int i =DBconn.addUpdDel(sql);
        if(i>0){
            flag = true;
        }
        DBconn.closeConn();
        return flag;
    }
    public boolean delete2(int id) {
        boolean flag = false;
        DBconn.init();
        String sql = "delete  from news where news_id="+id;
        int i =DBconn.addUpdDel(sql);
        sql = "delete from message where id =" + id;
        DBconn.addUpdDel(sql);
        if(i>0){
            flag = true;
        }
        DBconn.closeConn();
        return flag;
    }
    public List<facility> search(int facility_id) {
        List<facility> list = new ArrayList<facility>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from facility where facility_id= "+facility_id);
            while(rs.next()){
                facility facility = new facility();
                facility.setFacility_id(rs.getInt("facility_id"));
                facility.setFacility_name(rs.getString("facility_name"));
                facility.setFacility_business(rs.getString("facility_business"));
                facility.setPhone(rs.getString("phone"));;
                facility.setDuty_people(rs.getString("duty_people"));
                facility.setControl_people(rs.getString("control_people"));
                facility.setMoney(rs.getInt("money"));
                list.add(facility);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<facility> search2(String facility_name) {
        List<facility> list = new ArrayList<facility>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from facility where facility_name= '"+facility_name+"'");
            while(rs.next()){
                facility facility = new facility();
                facility.setFacility_id(rs.getInt("facility_id"));
                facility.setFacility_name(rs.getString("facility_name"));
                facility.setFacility_business(rs.getString("facility_business"));
                facility.setPhone(rs.getString("phone"));;
                facility.setDuty_people(rs.getString("duty_people"));
                facility.setControl_people(rs.getString("control_people"));
                facility.setMoney(rs.getInt("money"));
                list.add(facility);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<facility> search3(int money) {
        List<facility> list = new ArrayList<facility>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from facility where money= "+money);
            while(rs.next()){
                facility facility = new facility();
                facility.setFacility_id(rs.getInt("facility_id"));
                facility.setFacility_name(rs.getString("facility_name"));
                facility.setFacility_business(rs.getString("facility_business"));
                facility.setPhone(rs.getString("phone"));;
                facility.setDuty_people(rs.getString("duty_people"));
                facility.setControl_people(rs.getString("control_people"));
                facility.setMoney(rs.getInt("money"));
                list.add(facility);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<news> search4(int news_id) {
        List<news> list = new ArrayList<>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from news where news_id= "+news_id);
            while(rs.next()){
                news news1 = new news();
                news1.setNews_id(rs.getInt("news_id"));
                news1.setNews_content(rs.getString("news_content"));
                news1.setMonth(rs.getInt("month"));
                news1.setDay(rs.getInt("day"));
                news1.setName(rs.getString("name"));
                news1.setPublished(rs.getString("published"));
                list.add(news1);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<news> search5(String content) {
        List<news> list = new ArrayList<>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from news where news_content= '"+content+"'");
            while(rs.next()){
                news news1 = new news();
                news1.setNews_id(rs.getInt("news_id"));
                news1.setNews_content(rs.getString("news_content"));
                news1.setMonth(rs.getInt("month"));
                news1.setDay(rs.getInt("day"));
                news1.setName(rs.getString("name"));
                news1.setPublished(rs.getString("published"));
                list.add(news1);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<news> search6(String name) {
        List<news> list = new ArrayList<news>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from news where name= '"+name+"'");
            while(rs.next()){
                news news1 = new news();
                news1.setNews_id(rs.getInt("news_id"));
                news1.setNews_content(rs.getString("news_content"));
                news1.setMonth(rs.getInt("month"));
                news1.setDay(rs.getInt("day"));
                news1.setName(rs.getString("name"));
                news1.setPublished(rs.getString("published"));
                list.add(news1);
            }
            DBconn.closeConn();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
