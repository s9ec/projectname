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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/fee/editWa")
public class editWater extends HttpServlet {


    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);  //将信息使用doPost方法执行   对应jsp页面中的form表单中的method
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String record_id = request.getParameter("record_id");
        int id = Integer.parseInt(record_id);

        FeeDao feeDao = new FeeDaoImpl();

        WaterRecord waterRecord = new WaterRecord();
        try {
            waterRecord = feeDao.editWaterById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String s = null;
        if(waterRecord.getStatus().equals("未交")){
            s = "已交";
        }
        else{
            s = "未交";
        }
        request.setAttribute("theOther",s);
        request.setAttribute("editWater", waterRecord);//得到了当前的信息
        request.getRequestDispatcher("/page/fee/editWater.jsp").forward(request, response);
    }




}
