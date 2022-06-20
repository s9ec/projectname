package com.servlet.worker;

import com.dao.WorkerDao;
import com.dao.impl.WorkerDaoImpl;
import com.entity.worker.Absent;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/employee/absent")
public class absent extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        doPost(request, response);  //将信息使用doPost方法执行   对应jsp页面中的form表单中的method
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        String sql = "SELECT * FROM absent where status = '待批'";
        List<Absent> absents= new ArrayList<>();
        WorkerDao workerDao  = new WorkerDaoImpl();
        try {
            absents = workerDao.getUnapproved(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("absents",absents);
        request.getRequestDispatcher("/page/worker/listAbsents.jsp").forward(request, response);
    }
}
