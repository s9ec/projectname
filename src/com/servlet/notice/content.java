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

@WebServlet("/dept/content")
public class content extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        doPost(request, response);  //将信息使用doPost方法执行   对应jsp页面中的form表单中的method
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        int news_id = Integer.parseInt(request.getParameter("news_id"));//得到密码
//        if (news_id==1){
//            request.getRequestDispatcher("/page/notice/content.jsp").forward(request, response);//转发到成功页面
//        }
//        if (news_id==2){
//            request.getRequestDispatcher("/page/notice/content1.jsp").forward(request, response);//转发到成功页面
//        }
//        if (news_id==3){
//            request.getRequestDispatcher("/page/notice/content2.jsp").forward(request, response);//转发到成功页面
//        }
//        if (news_id==4){
//            request.getRequestDispatcher("/page/notice/content3.jsp").forward(request, response);//转发到成功页面
//        }
//        if (news_id==5){
//            request.getRequestDispatcher("/page/notice/content4.jsp").forward(request, response);//转发到成功页面
//        }
        String sql = "select * from message where id =" +news_id;
        DBconn.init();
        ResultSet rs = DBconn.selectSql(sql);
        String m = "";
        while(true) {
            try {
                if (!rs.next()) break;
                m = rs.getString("content");

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        request.setAttribute("message",m);
        request.setAttribute("id",news_id);
        System.out.println("m is " + m + "id is " + news_id);
        request.getRequestDispatcher("/page/notice/show.jsp").forward(request, response);
    }

}
