package com.servlet.resident;

import com.dao.ResiDao;
import com.dao.impl.ResiDaoImpl;
import com.entity.resident.Address;
import com.entity.resident.Resi_info;
import com.entity.resident.Resident;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/user/add")
public class AddResi extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);  //将信息使用doPost方法执行   对应jsp页面中的form表单中的method
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int community_id =Integer.parseInt(request.getParameter("community"));
        int building_id = Integer.parseInt(request.getParameter("building"));
        int unit_id = Integer.parseInt(request.getParameter("unit"));
        int room_id = Integer.parseInt(request.getParameter("room"));
        Address address = new Address();
        address.setCommunityNumber(community_id);
        address.setBuildingNumber(building_id);
        address.setUnitNumber(unit_id);
        address.setRoomNumber(room_id);
        ResiDao rd = new ResiDaoImpl();
        Resident resident = new Resident();
        resident.setAddress(address);
        Resi_info resi_info = new Resi_info();
        String houseName = request.getParameter("houseHoldName");
        String gender = request.getParameter("gender");
        String homePN = request.getParameter("homePN");
        String homePN2 = request.getParameter("homePN2");
        String mBP = request.getParameter("mBP");
        String workN = request.getParameter("workN");
        String wPN = request.getParameter("wPN");
        String wP = request.getParameter("wP");
        boolean flag = false;
        try {
            flag = rd.exist(address);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(flag){//代表有重复

        request.getRequestDispatcher("/page/user/add.jsp").forward(request, response);
       }
        else{
            ResiDao resiDao = new ResiDaoImpl();
            String sql = "insert into household_information(household_name,sex,family_phone1,family_phone2,mobile_phone,work) VALUE('"+houseName+"','"+gender+"','"+homePN+"','"+homePN2+"','" +mBP+"','"+workN+"')";
            String sql2 = "insert into position_of_user(community_id,building_id,unit_id,room_id) value(" + community_id
            + "," + building_id + "," + unit_id + "," + room_id + ")";
            boolean a = resiDao.update(sql);
            boolean b = resiDao.update(sql2);
            request.getRequestDispatcher("/user/list").forward(request, response);
        }
    }

}
