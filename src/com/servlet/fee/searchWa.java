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

@WebServlet("/fee/searchWa")
public class searchWa extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);  //将信息使用doPost方法执行   对应jsp页面中的form表单中的method
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Hid = request.getParameter("houseId");//得到了整数的hid
        String method = request.getParameter("selection");
        int m = Integer.parseInt(method);
        boolean flag = true;
        for(int i = 0; i < Hid.length(); i++){
            if(!Character.isDigit(Hid.charAt(i))){
                flag =false;
                break;
            }
        }
        if(flag == false){
            request.getRequestDispatcher("/page/fee/listwater.jsp").forward(request, response);
            return;
        }
        int hid = Integer.parseInt(Hid);

        FeeDao feeDao = new FeeDaoImpl();

        List<WaterRecord> waterRecords = new ArrayList<>();
        try {
            waterRecords = feeDao.getWaByHid(hid,m);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("water", waterRecords);
        request.getRequestDispatcher("/page/fee/listwater.jsp").forward(request, response);
    }
}
