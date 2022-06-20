package com.dao.impl;

import com.dao.WorkerDao;
import com.entity.worker.Absent;
import com.entity.worker.Worker;
import com.entity.worker.schedule;
import com.util.DBconn;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class WorkerDaoImpl implements WorkerDao {
    @Override
    public List<Worker> getWorkerAll() throws SQLException {
        List<Worker> list= new ArrayList<>();
        DBconn.init();
        String sql = "SELECT * FROM worker";
        ResultSet resultSet =  DBconn.selectSql(sql);
        while (resultSet.next()){
            Worker w = new Worker();
            w.setId(resultSet.getInt("worker_id"));
            w.setName(resultSet.getString("name"));
            w.setAge(resultSet.getInt("age"));
            w.setGender(resultSet.getString("gender"));
            w.setBase_salary(resultSet.getInt("base_salary"));
            w.setKind(resultSet.getString("kinds"));
            w.setBonus(resultSet.getInt("bonus"));
            w.setFinal_salary(w.getBase_salary() + w.getBonus());
            list.add(w);
        }
        return list;
    }

    @Override
    public boolean update(String sql){
        DBconn.init();
        int count = DBconn.addUpdDel(sql);
        if(count != 0)
            return true;
        return false;
    }

    public Worker getWorker(String sql) throws SQLException {
        Worker w = null;
        DBconn.init();
        ResultSet resultSet = DBconn.selectSql(sql);
        if(resultSet.next()){
            w = new Worker();
            w.setId(resultSet.getInt("worker_id"));
            w.setName(resultSet.getString("name"));
            w.setAge(resultSet.getInt("age"));
            w.setGender(resultSet.getString("gender"));
            w.setBase_salary(resultSet.getInt("base_salary"));
            w.setKind(resultSet.getString("kinds"));
            w.setBonus(resultSet.getInt("bonus"));
            w.setFinal_salary(w.getBase_salary() + w.getBonus());
        }
        return w;
    }
    public List<Worker> searchWorker(String sql) throws SQLException {

        List<Worker>workers = new ArrayList<>();
        DBconn.init();
        ResultSet resultSet = DBconn.selectSql(sql);
        while (resultSet.next()){
            Worker w = new Worker();
            w.setId(resultSet.getInt("worker_id"));
            w.setName(resultSet.getString("name"));
            w.setAge(resultSet.getInt("age"));
            w.setGender(resultSet.getString("gender"));
            w.setBase_salary(resultSet.getInt("base_salary"));
            w.setBonus(resultSet.getInt("bonus"));
            w.setKind(resultSet.getString("kinds"));
            w.setFinal_salary(w.getBase_salary() + w.getBonus());
            workers.add(w);
        }
        return workers;
    }
    public List<Absent> getUnapproved(String sql) throws SQLException {
        List<Absent> absents= new ArrayList<>();
        DBconn.init();
        ResultSet rs = DBconn.selectSql(sql);
        while (rs.next()){
            Absent absent = new Absent();
            absent.setId(rs.getInt("id"));
            absent.setName(rs.getString("name"));
            absent.setStatus(rs.getString("status"));
            absent.setMonth(rs.getInt("month"));
            absent.setDay(rs.getInt("day"));
            absent.setReason(rs.getString("reason"));
            absent.setManager(rs.getString("manager"));
            absents.add(absent);
        }
        return absents;
    }
    public boolean pi(String sql){
        DBconn.init();
        int count = DBconn.addUpdDel(sql);
    if(count == 0)
        return false;
    return true;
    }

    @Override
    public List<schedule> getSchedule() throws SQLException {
        DBconn.init();
        List<schedule> list = new ArrayList<>();
        String sql = "SELECT * FROM schedule a,worker b where a.worker_id = b.worker_id and day = ";
        String[] weeks = {"星期一","星期二","星期三","星期四","星期五","星期六","星期日"};

        int index = 0;
        for(int i = 1; i <= 7; i++){
            schedule s = new schedule();
            String sql1 = sql + i ;
            ResultSet rs = DBconn.selectSql(sql1);
            while(rs.next()){
                if(rs.getString("job").equals("保安")){
                    s.setBaoan(rs.getString("name"));
                }
                else if(rs.getString("job").equals("保洁")){
                    s.setBaojie(rs.getString("name"));
                }
                else if(rs.getString("job").equals("程序员")){
                    s.setChengxu(rs.getString("name"));
                }
                else if(rs.getString("job").equals("维修员")){
                    s.setWeixiu(rs.getString("name"));
                }
            }
            s.setXingqiji(weeks[i - 1]);
            list.add(s);
        }
        return list;
    }

    public int getDay(){
        Date date = new Date();
        String[] weeks = {"星期日","星期一","星期二","星期三","星期四","星期五","星期六"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int week_index = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if(week_index<0){
            week_index = 7;
        }
        return week_index;
    }

    public boolean getWorkerId(String name,int day) throws SQLException {
        DBconn.init();
        String sql = "SELECT worker_id from worker where name ='" + name + "'";
        ResultSet rs = DBconn.selectSql(sql);
        int id = 0;
        if(rs.next()){
            id = rs.getInt("worker_id");
        }
        sql = "select * from schedule where worker_id =" + id + " and day = " + day;
        rs = DBconn.selectSql(sql);
        if(rs.next()){
            return true;
        }
        return false;
    }

    public  String job(String name) throws SQLException {
        String job = "无";
        DBconn.init();
        String sql = "SELECT worker_id from worker where name ='"+name+"'";
        ResultSet rs = DBconn.selectSql(sql);
        int id = 0;
        if(rs.next()){
            id = rs.getInt("worker_id");
        }
        //得到了Id
        sql = "select * from schedule where worker_id ="+id;
        rs = DBconn.selectSql(sql);
        if(rs.next()){
            job = rs.getString("job");
        }
        return job;
    }

}
