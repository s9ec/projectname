package com.entity.record;

import com.util.DBconn;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

public class fillingDatabase {

    public double caculate(int q){
        double ans = q;
        if(q < 200){
            return ans * 1.5;
        }
        else if(q < 300)
            return ans*1.65;
        else if(q < 400)
            return ans* 1.88;
        else  if(q < 500)
            return ans * 2.2;
        else if(q < 600)
            return ans * 2.5;
        else return ans * 3;

    }
    public void insert(){
      DBconn.init();
      for(int i = 1; i <= 96; i++){//控制hid
          for(int j = 1; j <= 5; j++)//控制月份
          {
              String sql = "INSERT INTO water_record(hid,month,water_consumption,water_fee,status) value(" + i +"," + j +",";
              Random random = new Random();
              int water_consumption = random.nextInt(800);
              double fee = caculate(water_consumption);
              String status = "已交";
              sql += water_consumption + "," + fee + ",'" + status + "')";
              DBconn.addUpdDel(sql);
          }
      }
    }

    public void jiao(){
        DBconn.init();
        for(int hid = 1; hid <= 96; hid++){
            Random random = new Random();
            int b = random.nextInt(7) + 1; //j 属于1 - 6
            for(int j = b; j <= 5; j++){
                String sql = "update electricity_record set status ='未交' where hid = " + hid + " and month = " + j;
                DBconn.addUpdDel(sql);
            }
        }
        DBconn.closeConn();
    }

    public void set(){
        DBconn.init();
        for(int i = 481; i <= 960; i++){
            String sql = "update water_record set status ='已交' where record_id = " + i;
            DBconn.addUpdDel(sql);
        }
    }
    public void fill() throws SQLException {
        DBconn.init();
        String sql = "SELECT * From household_information";
        ResultSet rs = DBconn.selectSql(sql);
        while(rs.next()){
            int name = rs.getInt("hid");
            String pwd = rs.getString("household_name");
            String sql2 = "INSERT INTO user(name,pwd,level) value('" + name + "','" + pwd + "',3)";
            DBconn.addUpdDel(sql2);
        }
        DBconn.closeConn();
    }

    public void sex() throws SQLException {
        DBconn.init();
        String sql = "";
        for(int i = 1; i<= 95; i++){
            String names = "";
        ResultSet rs = DBconn.selectSql("select name from user where name ='" + i+"'");
        if(rs.next()){
            names = rs.getString("name");
        }
            sql = "update user set userName ='" + names + "' where name ='" + i + "'" ;
            DBconn.addUpdDel(sql);
        }
DBconn.closeConn();
    }

    public static void main(String args[]) throws SQLException {
        fillingDatabase w = new fillingDatabase();
        w.sex();
    }

}
