package com.servlet.fee;

import com.dao.FeeDao;
import com.dao.impl.FeeDaoImpl;
import com.entity.record.EleRecord;
import com.entity.record.WaterRecord;
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
@WebServlet("/fee/ListAll")
public class ListAll extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);  //将信息使用doPost方法执行   对应jsp页面中的form表单中的method
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String houseId = request.getParameter("houseId");//得到HouseId;
        int rid = Integer.parseInt(houseId);
        String sql = "SELECT * From water_record where hid =" + rid;
        String sql2 = "SELECT * from electricity_record where hid =" + rid;
        DBconn.init();
        ResultSet rs = DBconn.selectSql(sql);
        List<WaterRecord> waterRecords = new ArrayList<>();
        List<EleRecord> eleRecords = new ArrayList<>();
        while (true) {
            try {
                if (!rs.next()) break;
                WaterRecord waterRecord = new WaterRecord();
                waterRecord.setRecord_id(rs.getInt("record_id"));
                waterRecord.setHid(rs.getInt("hid"));
                waterRecord.setConsumption(rs.getInt("water_consumption"));
                waterRecord.setMonth(rs.getInt("month"));
                waterRecord.setFee(rs.getInt("water_fee"));
                waterRecord.setStatus(rs.getString("status"));
                if(waterRecord.getStatus().equals( "未交"))
                waterRecords.add(waterRecord);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
            rs = DBconn.selectSql(sql2);
            while (true) {
                try {
                    if (!rs.next()) break;
                    EleRecord eleRecord = new EleRecord();
                    eleRecord.setRecord_id(rs.getInt("record_id"));
                    eleRecord.setHid(rs.getInt("hid"));
                    eleRecord.setConsumption(rs.getInt("ele_consumption"));
                    eleRecord.setMonth(rs.getInt("month"));
                    eleRecord.setFee(rs.getInt("ele_fee"));
                    eleRecord.setStatus(rs.getString("status"));
                    if(eleRecord.getStatus().equals("未交"))
                    eleRecords.add(eleRecord);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            DBconn.closeConn();
            request.setAttribute("waterFee",waterRecords);
            request.setAttribute("eleFee",eleRecords);
        request.getRequestDispatcher("/page/fee/payList.jsp").forward(request, response);

    }

}
