package com.servlet.worker;

import com.dao.WorkerDao;
import com.dao.impl.WorkerDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/worker/bupi")
public class bupi extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        doPost(request, response);  //将信息使用doPost方法执行   对应jsp页面中的form表单中的method
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        String sql = "UPDATE absent set status = '拒批',manager = '" + request.getParameter("manager") +  "' where id = " + request.getParameter("id") ;
        WorkerDao workerDao = new WorkerDaoImpl();
        boolean b = workerDao.pi(sql);//
        request.getRequestDispatcher("/page/worker/listAbsents.jsp").forward(request, response);
    }
}
