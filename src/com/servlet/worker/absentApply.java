package com.servlet.worker;

import com.dao.WorkerDao;
import com.dao.impl.WorkerDaoImpl;
import com.entity.worker.Add;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/worker/apply")
public class absentApply extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        doPost(request, response);  //将信息使用doPost方法执行   对应jsp页面中的form表单中的method
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        String month = request.getParameter("month");
        String day = request.getParameter("day");
        String reason = request.getParameter("reason");
        String name = request.getParameter("name");
        String sql = "insert into absent(name,month,day,reason,status) value('" + name +"','"+month
                +"','"+day + "','"+reason + "','待批')";
        WorkerDao workerDao = new WorkerDaoImpl();
        boolean b = workerDao.update(sql);
        request.getRequestDispatcher("/page/apply.jsp").forward(request, response);
    }

}
