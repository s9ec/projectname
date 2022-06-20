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

@WebServlet("/fee/updateEle")
public class updateElectricity extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);  //将信息使用doPost方法执行   对应jsp页面中的form表单中的method
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FeeDao feeDao = new FeeDaoImpl();
        String consumption = request.getParameter("con");
        String fee = request.getParameter("fee");
        String status = request.getParameter("status");
        String id = request.getParameter("record_id");
        String sql = "UPDATE electricity_record set ele_consumption =" + consumption + ",ele_fee =" + fee
                + ", status ='" + status + "' where record_id =" + id;
        boolean f = feeDao.update(sql);
    }

}
