package com.servlet.notice;

import com.util.DBconn;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/dept/content3")
public class content3 extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        doPost(request, response);  //将信息使用doPost方法执行   对应jsp页面中的form表单中的method
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

        int news_id = Integer.parseInt(request.getParameter("news_id"));//得到id
        String S="";
        DBconn.init();
        String sql = "SELECT content from message where id = " + news_id;
        ResultSet rs = DBconn.selectSql(sql);
        try {
            if(rs.next()){}
            S = rs.getString("content");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("s",S); //向request域中放置信息
        request.getRequestDispatcher("/page/notice/content.jsp").forward(request, response);//转发到成功页面

    }

}