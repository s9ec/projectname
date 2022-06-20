package com.servlet.resident;

import com.dao.ResiDao;
import com.dao.impl.ResiDaoImpl;
import com.entity.resident.Member_info;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/user/familyMember")
public class familyMember extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        doPost(request, response);  //将信息使用doPost方法执行   对应jsp页面中的form表单中的method
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

        int hid = Integer.parseInt(request.getParameter("hid"));//得到密码
        ResiDao rd = new ResiDaoImpl();
        List<Member_info> member = new ArrayList<>();//得到家庭成员列表
        try {
            member = rd.getFamily(hid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
            request.setAttribute("current_id",hid);//得到当前正在浏览的Hid
            request.setAttribute("member",member); //向request域中放置这个列表
            request.getRequestDispatcher("/page/user/family.jsp").forward(request, response);//将列表传过去

    }

}
