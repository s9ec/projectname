package com.servlet.menu;

import com.dao.UserDao;
import com.dao.impl.UserDaoImpl;
import com.entity.resident.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/account/insert")
public class insertAccount extends HttpServlet {
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
        UserDao userDao = new UserDaoImpl();
        int level = Integer.parseInt(request.getParameter("level"));
        User user = new User();
        user.setName(name);
        user.setPwd(pwd);
        user.setLevel(level);
        user.setUserName(userName);
        user.setGender(gender);
        boolean b = userDao.register(user);
        request.getRequestDispatcher("/account/list").forward(request, response);
    }
}
