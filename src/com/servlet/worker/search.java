package com.servlet.worker;

import com.dao.WorkerDao;
import com.dao.impl.WorkerDaoImpl;
import com.entity.worker.Worker;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/worker/search")
public class search extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        doPost(request, response);  //将信息使用doPost方法执行   对应jsp页面中的form表单中的method
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        String name = request.getParameter("name");//得到名字
        String sql = "SELECT * FROM WORKER WHERE name like '%" + name + "%'";
        WorkerDao workerDao = new WorkerDaoImpl();
        List<Worker> workers = new ArrayList<>();
        try {
           workers = workerDao.searchWorker(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("workers",workers);
        request.getRequestDispatcher("/page/worker/listByName.jsp").forward(request, response);
    }

}
