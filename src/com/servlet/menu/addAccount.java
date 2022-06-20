package com.servlet.menu;

import com.dao.UserDao;
import com.dao.impl.UserDaoImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/account/judgeRepeat")
public class addAccount extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        doPost(request, response);  //将信息使用doPost方法执行   对应jsp页面中的form表单中的method
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

        UserDao userDao = new UserDaoImpl();
        String name = request.getParameter("uname");
        boolean isRepeat = false;
        try {
            isRepeat = userDao.repeat(name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(isRepeat){//重复啦
            response.getWriter().write("账号已存在");
        }
        else{
            response.getWriter().write("账号可用");
        }
    }
}
