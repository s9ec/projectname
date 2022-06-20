package com.servlet.worker;

import com.dao.WorkerDao;
import com.dao.impl.WorkerDaoImpl;
import com.entity.worker.schedule;
import com.util.DBconn;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/worker/listByXingqiji")
public class listScheduleByXingqiji extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        doPost(request, response);  //将信息使用doPost方法执行   对应jsp页面中的form表单中的method
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        String xingqiji =request.getParameter("xingqiji");
        System.out.println(xingqiji);
        int day = 0;
        if(xingqiji.equals("星期一")){
            day = 1;
        }
        if(xingqiji.equals("星期二")){
            day = 2;
        }

        if(xingqiji.equals("星期三")){
            day = 3;
        }

        if(xingqiji.equals("星期四")){
            day = 4;
        }

        if(xingqiji.equals("星期五")){
            day = 5;
        }

        if(xingqiji.equals("星期六")){
            day = 6;
        }

        if(xingqiji.equals("星期日")){
            day = 7;
        }
        System.out.println(day);
        String sql = "select * from worker a, schedule b where a.worker_id = b.worker_id and day = " + day;
        //列出当天的排班表
        DBconn.init();
        ResultSet rs = DBconn.selectSql(sql);
        schedule s = new schedule();
        while(true){
            try {
                if (!rs.next()) break;
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
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        List<String>baoanji = new ArrayList<>();
        List<String>baojieji = new ArrayList<>();
        List<String>weixiuji = new ArrayList<>();
        List<String>chengxuji = new ArrayList<>();
        sql = "select distinct name from worker where kinds = '保安' and name != '" + s.getBaoan()+"'";
        rs = DBconn.selectSql(sql);
        while(true){
            try {
                if (!rs.next()) break;
                baoanji.add(rs.getString("name"));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        sql = "select distinct name from worker where kinds = '保洁' and name != '" + s.getBaojie()+"'";
        rs = DBconn.selectSql(sql);
        while(true){
            try {
                if (!rs.next()) break;
                baojieji.add(rs.getString("name"));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        sql = "select distinct name from worker where kinds = '维修员' and name != '" + s.getWeixiu()+"'";
        rs = DBconn.selectSql(sql);
        while(true){
            try {
                if (!rs.next()) break;
                weixiuji.add(rs.getString("name"));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        sql = "select distinct name from worker where kinds = '程序员' and name != '" + s.getChengxu()+"'";
        rs = DBconn.selectSql(sql);
        while(true){
            try {
                if (!rs.next()) break;
                chengxuji.add(rs.getString("name"));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        request.setAttribute("baoanji",baoanji);
        request.setAttribute("baojieji",baojieji);
        request.setAttribute("weixiuji",weixiuji);
        request.setAttribute("chengxuji",chengxuji);
        request.setAttribute("current",s);
        request.setAttribute("day",day);
        request.getRequestDispatcher("/page/worker/listByDay.jsp").forward(request, response);
    }

}
