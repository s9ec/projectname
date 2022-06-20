package com.servlet.fee;

import com.dao.FeeDao;
import com.dao.impl.FeeDaoImpl;
import com.entity.record.EleRecord;
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

@WebServlet("/fee/editEle")
public class editEle extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);  //将信息使用doPost方法执行   对应jsp页面中的form表单中的method
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String record_id = request.getParameter("record_id");//得到了recordId
        int id = Integer.parseInt(record_id);
        FeeDao feeDao = new FeeDaoImpl();
        EleRecord eleRecord = new EleRecord();
        try {
            eleRecord = feeDao.editEleById(id);//得到记录
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String s = null;
        if(eleRecord.getStatus().equals("未交")){
            s = "已交";
        }
        else{
            s = "未交";
        }
        request.setAttribute("theOther",s);
        request.setAttribute("editEle", eleRecord);
        request.getRequestDispatcher("/page/fee/editEle.jsp").forward(request, response);
    }




}
