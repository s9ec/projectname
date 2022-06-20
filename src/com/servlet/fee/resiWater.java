package com.servlet.fee;

import com.dao.FeeDao;
import com.dao.impl.FeeDaoImpl;
import com.entity.record.WaterRecord;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/fee/waterList3")
public class resiWater extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);  //将信息使用doPost方法执行   对应jsp页面中的form表单中的method
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        FeeDao feeDao = new FeeDaoImpl();
        List<WaterRecord> list = null;
        try {
            list  = feeDao.getWaByHid(Integer.parseInt(name),1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("waterList",list);
        request.getRequestDispatcher("/page/client/water.jsp").forward(request, response);
    }

}
