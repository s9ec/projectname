package com.servlet.notice;

import com.dao.ResiDao2;
import com.dao.impl.ResiDaoImpl2;
import com.entity.record_info;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/dept/check")
public class check extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        doPost(request, response);  //将信息使用doPost方法执行   对应jsp页面中的form表单中的method
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

        int facility_id = Integer.parseInt(request.getParameter("facility_id"));//得到密码
        ResiDao2 rd = new ResiDaoImpl2();
        List<record_info> record = new ArrayList<>();
        try {
            record = rd.getrecord(facility_id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("record",record); //向request域中放置信息
        request.getRequestDispatcher("/page/dept/check.jsp").forward(request, response);//转发到成功页面

    }

}
