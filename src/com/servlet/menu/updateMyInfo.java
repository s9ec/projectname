package com.servlet.menu;

import com.util.DBconn;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/client/updateMyInfo")
public class updateMyInfo extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        doPost(request, response);  //将信息使用doPost方法执行   对应jsp页面中的form表单中的method
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        String name = request.getParameter("name");
        String pwd = request.getParameter("pwd");
        String userName = request.getParameter("userName");
        String gender = request.getParameter("gender");
        String sql = "update user set pwd ='" + pwd + "',userName ='" + userName + "',sex ='" + gender
                + "' where name ='" + name+ "'";
        DBconn.init();
        int b = DBconn.addUpdDel(sql);
        System.out.println("b is " + b);
    }
}
