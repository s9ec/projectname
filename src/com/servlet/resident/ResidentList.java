
package com.servlet.resident;

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
import java.util.List;

@WebServlet("/user/list1")
public class ResidentList extends HttpServlet {  //需要继承HttpServlet  并重写doGet  doPost方法
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        doPost(request, response);  //将信息使用doPost方法执行   对应jsp页面中的form表单中的method
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        UserDao ud = new UserDaoImpl();
        List<User> userAll = ud.getUserAll();
        try {
            int count = ud.count();
            if(count != -1){
                request.setAttribute("count",count);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("List", userAll);
        request.getRequestDispatcher("/page/user/list.jsp").forward(request, response);
    }
}
