package com.servlet.notice;
import com.dao.UsersDao;
import com.dao.impl.UsersDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/dept/content1")
public class content1 extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        doPost(request, response);  //将信息使用doPost方法执行   对应jsp页面中的form表单中的method
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

        int news_id = Integer.parseInt(request.getParameter("news_id"));//得到密码
        UsersDao ud = new UsersDaoImpl();
        try {
            if(ud.getcontent(news_id)){
                request.getRequestDispatcher("/page/welcome1?a=1").forward(request, response);
            }else{
                response.sendRedirect("index.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
