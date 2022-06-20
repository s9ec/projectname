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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/account/searchAccount")
public class searchAccount extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        doPost(request, response);  //将信息使用doPost方法执行   对应jsp页面中的form表单中的method
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        String name = request.getParameter("name");
        String sql = "SELECT * from user where name like '%" + name +"%'";//用模糊查询得到它的信息
        DBconn.init();
        ResultSet rs = DBconn.selectSql(sql);
        List<User> list = new ArrayList<>();
        while(true){
            try {
                if (!rs.next()) break;
                User user = new User();
                user.setName(rs.getString("name"));
                user.setId(rs.getInt("id"));
                user.setPwd(rs.getString("pwd"));
                user.setLevel(rs.getInt("level"));
                user.setKinds();
                list.add(user);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        request.setAttribute("info",list);
        request.getRequestDispatcher("/page/client/listByAccount.jsp").forward(request, response);
    }
}
