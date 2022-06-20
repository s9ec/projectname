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

@WebServlet("/worker/update")
public class updateWorker extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        doPost(request, response);  //将信息使用doPost方法执行   对应jsp页面中的form表单中的method
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {//进行编辑
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String base_salary = request.getParameter("base_salary");
        String kinds = request.getParameter("kinds");
        String bonus = request.getParameter("bonus");
        String sql = "update worker set name = '" + name  + "',age = " + age + ",base_salary ="
                +base_salary + ",bonus = " + bonus + ",kinds ='" + kinds + "' " + " where worker_id = " + id;
        WorkerDao workerDao = new WorkerDaoImpl();
        boolean b = workerDao.update(sql);
        System.out.println(b);

        request.getRequestDispatcher("/worker/list").forward(request, response);
    }
}
