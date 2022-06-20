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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/account/list")
public class account extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        doPost(request, response);  //将信息使用doPost方法执行   对应jsp页面中的form表单中的method
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

        UserDao userDao = new UserDaoImpl();
        List<User>list = new ArrayList<>();
        list = userDao.getUserAll();
        request.setAttribute("userList",list);
        request.getRequestDispatcher("/page/client/userList.jsp").forward(request, response);
    }

}
