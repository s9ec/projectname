package com.servlet.notice;

import com.dao.ResiDao3;
import com.dao.impl.ResiDaoImpl3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/notice/add")
public class Addnotice extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);  //将信息使用doPost方法执行   对应jsp页面中的form表单中的method
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String news_content = request.getParameter("news_content");
        int month = Integer.parseInt(request.getParameter("month"));
        int day = Integer.parseInt(request.getParameter("day"));
        String name = request.getParameter("name");
        ResiDao3 rd = new ResiDaoImpl3();
        rd.insert(news_content, month, day, name);
        request.getRequestDispatcher("/notice/list").forward(request, response);
    }

}
