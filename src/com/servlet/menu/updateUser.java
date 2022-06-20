package com.servlet.menu;

import com.dao.UserDao;
import com.dao.impl.UserDaoImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/updateUser")
public class updateUser extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        doPost(request, response);  //将信息使用doPost方法执行   对应jsp页面中的form表单中的method
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        int  id = Integer.parseInt(request.getParameter("ids"));
        String name = request.getParameter("name");
        String pwd = request.getParameter("pwd");
        String kind = request.getParameter("kind");
        String gender = request.getParameter("sex");
        String userName = request.getParameter("userName");
        int level = 1;
        if(kind.equals("员工"))
            level = 2;
        else if(kind.equals("住户"))
            level = 3;
        else if(kind.equals("禁用"))
            level = 0;
        UserDao userDao = new UserDaoImpl();
        boolean b = userDao.update(id,name,pwd,level,userName,gender);
        request.getRequestDispatcher("/account/list").forward(request, response);
    }
}
