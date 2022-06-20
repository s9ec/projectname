package com.servlet.worker;

import com.dao.WorkerDao;
import com.dao.impl.WorkerDaoImpl;
import com.util.DBconn;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/worker/updateSchedule")
public class updateSchedule extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        doPost(request, response);  //将信息使用doPost方法执行   对应jsp页面中的form表单中的method
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        String day = request.getParameter("day");//得到日子
        String baoan = request.getParameter("baoan");
        String baojie = request.getParameter("baojie");
        String weixiu = request.getParameter("weixiu");
        String chengxu = request.getParameter("chengxu");
        DBconn.init();
        ResultSet rs = null;
        int worker_id = 0;
        String sql = null;
        String s  ="";
        int count = 0;

        s = "select worker_id from worker where name ='" + baoan + "'";//得到它的编号
         rs =  DBconn.selectSql(s);

        try {
            if(rs.next()){
                worker_id = rs.getInt("worker_id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        sql = "UPDATE schedule set worker_id =" + worker_id + " where day =" +day + " and job ='保安'";
         count = DBconn.addUpdDel(sql);



        s = "select worker_id from worker where name ='" + baojie + "'";//得到它的编号
        rs =  DBconn.selectSql(s);

        try {
            if(rs.next()){
                worker_id = rs.getInt("worker_id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        sql = "UPDATE schedule set worker_id =" + worker_id + " where day =" +day + " and job ='保洁'";
        count = DBconn.addUpdDel(sql);


        s = "select worker_id from worker where name ='" + weixiu + "'";//得到它的编号
        rs =  DBconn.selectSql(s);

        try {
            if(rs.next()){
                worker_id = rs.getInt("worker_id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        sql = "UPDATE schedule set worker_id =" + worker_id + " where day =" +day + " and job ='维修员'";
        count = DBconn.addUpdDel(sql);


        s = "select worker_id from worker where name ='" + chengxu + "'";//得到它的编号
        rs =  DBconn.selectSql(s);

        try {
            if(rs.next()){
                worker_id = rs.getInt("worker_id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        sql = "UPDATE schedule set worker_id =" + worker_id + " where day =" +day + " and job ='程序员'";
        count = DBconn.addUpdDel(sql);
        request.getRequestDispatcher("/worker/schedule").forward(request, response);
    }
}
