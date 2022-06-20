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
import java.sql.SQLException;

@WebServlet("/user/getInfo")
public class uGetInfo extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        doPost(request, response);  //将信息使用doPost方法执行   对应jsp页面中的form表单中的method
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        String id = request.getParameter("id");
        UserDao userDao = new UserDaoImpl();
        User user = null;
        try {
           user = userDao.getById(Integer.parseInt(id));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String g = "男";
        if(user.getGender().equals("男"))
            g="女";
        request.setAttribute("theOther",g);
        request.setAttribute("uinfo",user);
        request.getRequestDispatcher("/page/client/editUser.jsp").forward(request, response);
    }
}
