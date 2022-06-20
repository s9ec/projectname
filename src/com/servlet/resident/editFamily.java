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

@WebServlet("/user/query")

public class editFamily extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);  //将信息使用doPost方法执行   对应jsp页面中的form表单中的method

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id")); // 得到了整数id
        ResiDao resiDao = new ResiDaoImpl();
        Member_info member_info = new Member_info();
        try {
            member_info = resiDao.FamilyMember(id);//得到这个东西
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("F",member_info);
        request.setAttribute("memberId",id);
        request.getRequestDispatcher("/page/user/editFamilyMember.jsp").forward(request, response);
    }

}
