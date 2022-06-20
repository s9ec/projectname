package com.servlet.worker;

import com.dao.WorkerDao;
import com.dao.impl.WorkerDaoImpl;
import com.entity.worker.Worker;
import com.util.DBconn;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/worker/editWorker")
public class editWorker extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        doPost(request, response);  //将信息使用doPost方法执行   对应jsp页面中的form表单中的method
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {//进行编辑
        String id = request.getParameter("id");
        WorkerDao workerDao = new WorkerDaoImpl();
        String sql = "SELECT * FROM worker where worker_id = " + id;
        Worker worker = null;
        try {
             worker = workerDao.getWorker(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        sql = "SELECT jobs from jobkind where jobs != '" +worker.getKind() + "'";
        ResultSet resultSet = DBconn.selectSql(sql);
        List<String> j = new ArrayList<>();
        while (true){
            try {
                if (!resultSet.next()) break;
                j.add(resultSet.getString("jobs"));
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        request.setAttribute("jobs",j);
        request.setAttribute("editWorker",worker);
        request.getRequestDispatcher("/page/worker/editWorker.jsp").forward(request, response);
    }
}
