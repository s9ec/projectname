package com.servlet.notice;

import com.dao.ResiDao2;
import com.dao.impl.ResiDaoImpl2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/dept/add")
public class Addfaci extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);  //将信息使用doPost方法执行   对应jsp页面中的form表单中的method
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("进来啦吗");
        int facility_id =Integer.parseInt(request.getParameter("facility_id"));
        String facility_name = request.getParameter("facility_name");
        String facility_business = request.getParameter("facility_business");
        String phone = request.getParameter("phone");
        String duty_people = request.getParameter("duty_people");
        String control_people = request.getParameter("control_people");
        int money = Integer.parseInt(request.getParameter("money"));
        ResiDao2 rd = new ResiDaoImpl2();
        try {
            if (!rd.exist(facility_id)){
                if(rd.insert(facility_id,facility_name, facility_business, phone,duty_people,control_people,money)){
                    request.getRequestDispatcher("/dept/list").forward(request, response);
                }else{
                    response.sendRedirect("/page/dept/list.jsp");
                }
            }else {
                System.out.println("repeated id");
                request.getRequestDispatcher("/page/dept/repeated.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

}
