package com.dao.impl;

import com.dao.ResiDao3;
import com.entity.news;
import com.util.DBconn;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ResiDaoImpl3 implements ResiDao3 {
    public List<news> getnewsAll() {
        List<news> list = new ArrayList<>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from news");
            while(rs.next()){
//                int facility_id = 0;
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
    public List<String > checknewsAll() {
        List<String >list = new ArrayList<>();
        try {
            DBconn.init();
            ResultSet rs = DBconn.selectSql("select * from news where published = 'yes' ");
            while(rs.next()){
                String s = "";
                s += rs.getString("news_content");
                list.add(s);
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
        return "ResiDaoImpl3{}";
    }


//
//    public boolean exist(Address address) throws SQLException {
//        boolean flag = false;//本不存在
//        int community = address.getCommunityNumber();
//        int building = address.getBuildingNumber();
//        int unit = address.getUnitNumber();
//        int room = address.getRoomNumber();
//        String sql =  "select count(*) from position_of_user where community_id = " + community + " and building_id = " + building
//                + " and unit_id = " + unit + " and room_id = " + room;
//        DBconn.init();
//        ResultSet rs = DBconn.selectSql(sql);
//        int count = 0;
//        if(rs.next()){
//             count = rs.getInt("count(*)");
//             if(count != 0){
//                 flag = true;//有重复的啦
//             }
//        }
//        return flag;
//    }
//
public boolean exist(int news_id) throws SQLException {
    boolean flag = false;//本不存在
    String sql =  "select count(*) from news where news_id = " + news_id;
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

    public boolean insert(String news_content,int month, int day,String name){
       boolean flag = false;
       DBconn.init();
       String sql = "insert into news(news_content,month,day,name,published) VALUE('"+
               news_content+"',"+month+","+day+",'" +name+"','no')";
       int i =DBconn.addUpdDel(sql);
       if(i>0){
           flag = true;
       }
       sql = "insert into message(content) value('请编辑')";
        DBconn.addUpdDel(sql);
       DBconn.closeConn();
       return flag;
   }
    }


