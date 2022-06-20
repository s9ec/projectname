package com.servlet.menu;

import com.entity.resident.User;
import com.util.DBconn;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

@WebServlet("/user/myInformation")
public class myInformation extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        doPost(request, response);  //将信息使用doPost方法执行   对应jsp页面中的form表单中的method
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        String name = request.getParameter("name");
        String sql = "select * from user where name = '" +name +"'";//得到了该用户的账号和密码
        DBconn.init();
        ResultSet rs = DBconn.selectSql(sql);
        User u = new User();
        String gender = "男";
        try {
            if(rs.next()){
                u.setName(rs.getString("name"));
                u.setPwd(rs.getString("pwd"));
                u.setLevel(rs.getInt("level"));
                gender = rs.getString("sex");
                u.setUserName(rs.getString("userName"));
                u.setKinds();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("gender",gender);
        String g = "男";
        if(gender.equals("男"))
            g = "女";
        request.setAttribute("theOther",g);
        request.setAttribute("Users",u);
        request.getRequestDispatcher("/page/client/listMyInfo.jsp").forward(request, response);
    }
}
